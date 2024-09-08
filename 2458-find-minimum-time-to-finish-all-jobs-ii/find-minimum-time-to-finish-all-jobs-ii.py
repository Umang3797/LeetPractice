class Solution:
    def minimumTime(self, jobs: List[int], workers: List[int]) -> int:
        jobs.sort()
        workers.sort()
        
        res=0
        
        for jobTime, workTime in zip(jobs,workers):
            q, r = divmod(jobTime,workTime)
            if r!=0:
                q+=1
            
            res= max(res,q)
        
        return res
        