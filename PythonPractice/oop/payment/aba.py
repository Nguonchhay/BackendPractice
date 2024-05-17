from payment import Payment


class Aba(Payment):
    def __init__(self, amount):
        self.amount = amount

    def __str__(self):
        return f"ABA: {self.amount}"

    def pay(self):
        print("ABA: {self.amount} ")

    def get_amount(self):
        return self.amount
