from aba import Aba
from payment import Payment
from wing import Wing


def display_payments(py):
    for payment in py:
        print(payment)


print("Payment with OOP")
payments = [
    Aba(5.5),
    Aba(3.0),
    Wing(5.0),
    Aba(3.5),
    Wing(1.5)
]

display_payments(payments)
payments.sort()
print("Sorted Payments")
display_payments(payments)
