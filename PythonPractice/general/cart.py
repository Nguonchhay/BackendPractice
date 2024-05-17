cart = {}

index = 1
while True:
    product = {}
    name = input("Product name: ")
    qty = input("Product quantity: ")
    unit_price = input("Product unit price: ")
    product.update({
        "name": name,
        "qty": int(qty),
        "unit_price": float(unit_price)
    })
    cart[str(index)] = product
    index += 1

    answer = input("Press Y|y to continue: ")[0]
    if answer == "Y" or answer == "y":
        continue
    break

for product in cart.values():
    print(product)

