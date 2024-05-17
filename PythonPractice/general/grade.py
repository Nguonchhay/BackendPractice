""" Student Grade """
inputScore = input("Enter score: ")
score = int(inputScore)
if 90 <= score < 101:
    print("Grade A")
elif 80 <= score < 90:
    print("Grade B")
elif 70 <= score < 80:
    print("Grade C")
else:
    print("False")
