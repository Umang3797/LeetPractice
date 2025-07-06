class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        parent = {}
        owner = {}
        
        def find(x):
            parent.setdefault(x, x)
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
        
        # link emails and map them to owners
        for account in accounts:
            name = account[0]
            first_email = account[1]
            for email in account[1:]:
                union(first_email, email)
                owner[email] = name
        
        # group emails by their root parent
        groups = collections.defaultdict(list)
        for email in owner:
            groups[find(email)].append(email)
        
        # build the final answer
        res = []
        for root, emails in groups.items():
            res.append([owner[root]] + sorted(emails))
        return res

        