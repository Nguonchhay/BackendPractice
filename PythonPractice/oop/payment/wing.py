from payment import Payment


class Wing(Payment):
    def __init__(self, amount):
        self.amount = amount

    def __str__(self):
        return f"Wing: {self.amount}"

    def pay(self):
        print(f"Wing: {self.amount}")

    def get_amount(self):
        return self.amount

