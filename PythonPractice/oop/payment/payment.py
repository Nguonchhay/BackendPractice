class Payment:
    def __lt__(self, other):
        return self.get_amount() < other.get_amount()

    def pay(self):
        raise NotImplementedError("Sub-class must implement this")

    def get_amount(self):
        raise NotImplementedError("Sub-class must implement this")
