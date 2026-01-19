class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in range(len(s)):
            # If the character is not a closing bracket, push it onto the stack
            if s[i] != "]":
                stack.append(s[i])
            else:
                # 1. Extract the substring inside the brackets
                substr = ""
                while stack[-1] != "[":
                    # We add to the front because we're popping from the end
                    substr = stack.pop() + substr
                
                # Pop the opening bracket '['
                stack.pop()

                # 2. Extract the number k preceding the '['
                k = ""
                while stack and stack[-1].isdigit():
                    # Again, add to the front to handle multi-digit numbers like "100"
                    k = stack.pop() + k

                # 3. Repeat the substring k times and push it back to the stack
                stack.append(int(k) * substr)
                
        # Join the stack to get the final decoded string
        return "".join(stack)