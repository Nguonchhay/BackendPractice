from datetime import datetime
import time
from zoneinfo import ZoneInfo


# Format: Hong Heng, 13.1.2011
inputText = input("Enter your name and birth date: ")
inputName, inputBirthDate = inputText.split(",", 2)
print("Welcome " + inputName)

cambodiaTime = datetime.now(tz=ZoneInfo("Asia/Ho_Chi_Minh"))
