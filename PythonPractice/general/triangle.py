import math

inputA, inputB, inputC = input("Enter triangle edges: ").split(" ", 3)
edgeA = int(inputA)
edgeB = int(inputB)
edgeC = int(inputC)
perimeter = edgeA + edgeB + edgeC
area = math.sqrt(perimeter/2 - edgeA) * (perimeter/2 - edgeB) * (perimeter/2 - edgeC)
print("Area of Edge A: {0}, Edge B: {1}, Edge C: {2} is {3}".format(edgeA, edgeB, edgeC, area))
