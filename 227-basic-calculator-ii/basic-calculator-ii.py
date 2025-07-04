class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        last_op = '+'
        s = s.replace(" ", "")  # remove spaces

        for i, ch in enumerate(s):
            if ch.isdigit():
                num = num * 10 + int(ch)

            # if we see an operator or reach the end
            if ch in '+-*/' or i == len(s) - 1:
                if last_op == '+':
                    stack.append(num)
                elif last_op == '-':
                    stack.append(-num)
                elif last_op == '*':
                    stack.append(stack.pop() * num)
                elif last_op == '/':
                    prev = stack.pop()
                    # Python division to truncate toward zero
                    stack.append(int(prev / num))
                last_op = ch
                num = 0

        return sum(stack)

        