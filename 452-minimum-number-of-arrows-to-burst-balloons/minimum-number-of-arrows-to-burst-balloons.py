class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # Sort balloons by their start x-coordinate
        points.sort(key=lambda x: x[0])

        count = 1  # We need at least one arrow
        prev_end = points[0][1]  # End of the first balloon

        for x, y in points[1:]:
            # Overlapping balloon
            if x <= prev_end:
                prev_end = min(prev_end, y)
                continue
            
            # No overlap, need a new arrow
            prev_end = y
            count += 1
        return count
        