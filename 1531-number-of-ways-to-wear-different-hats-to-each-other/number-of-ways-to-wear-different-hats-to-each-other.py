class Solution:
    def numberWays(self, hats: List[List[int]]) -> int:

        MOD = 1_000_000_007
        n = len(hats)              # number of kids (people)
        FULL_MASK = (1 << n) - 1   # final target mask = all kids wearing hats (111...111)

        # -----------------------------
        # Step 1: Build reverse mapping
        # -----------------------------
        # Instead of "which hats does this kid like",
        # we store "which kids like this hat".
        # This makes it easier when we process hats one by one.
        hat_to_kids = [[] for _ in range(41)]   # index 1..40 (since hats are numbered 1..40)
        for kid, liked_hats in enumerate(hats):
            for h in liked_hats:
                hat_to_kids[h].append(kid)

        # -----------------------------
        # Step 2: DP setup
        # -----------------------------
        # dp[mask] = number of ways to reach this "mask".
        # A mask is like a binary string saying which kids already have hats.
        # Example for 3 kids:
        #   mask = 0b000 → no kid has a hat
        #   mask = 0b101 → kid1 and kid3 have hats, kid2 does not
        #   mask = 0b111 → all 3 kids have hats
        dp = [0] * (1 << n)
        dp[0] = 1   # base case: one way to start with nobody wearing hats

        # -----------------------------
        # Step 3: Process hats one by one
        # -----------------------------
        # For each hat (1..40), we decide:
        #   a) Skip it (nobody takes it)
        #   b) Assign it to ONE kid who likes it and does not already have a hat
        for h in range(1, 41):
            if not hat_to_kids[h]:
                continue   # if no kid likes this hat, we ignore it

            # Copy current dp state.
            # This "carry over" means we consider the option of SKIPPING this hat.
            new_dp = dp[:]

            # Now try to ASSIGN this hat to some kid
            for mask in range(1 << n):   # check every possible "who has hats" situation
                if dp[mask] == 0:
                    continue   # no valid way to reach this mask, skip it

                # Try giving hat h to each kid who likes it
                for kid in hat_to_kids[h]:
                    if (mask >> kid) & 1:
                        # This kid already has a hat in this mask → skip them
                        continue

                    # Otherwise, we give this hat to the kid:
                    # - Make a new mask where this kid’s bit is set to 1
                    new_mask = mask | (1 << kid)

                    # Add the number of ways to reach old mask into new mask
                    new_dp[new_mask] = (new_dp[new_mask] + dp[mask]) % MOD

            # Update dp for next hat
            dp = new_dp

        # -----------------------------
        # Step 4: Result
        # -----------------------------
        # The answer is the number of ways to reach the "all kids have hats" mask
        return dp[FULL_MASK]
