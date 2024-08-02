from flask import Flask, render_template, request, url_for, session, redirect


app = Flask(__name__)
app.secret_key = "12345678"


@app.route("/")
def homePage():
    return render_template("index.html")


@app.route("/about")
def aboutPage():
    return render_template("about.html")


@app.route("/contact")
def contactPage():
    return render_template("contact.html")


@app.route("/login", methods = ["POST", "GET"])
def login():
    if request.method == "POST":
        email = request.form['email']
        password = request.form['password']
        session["user"] = {
            "email": email,
            "name": "Fake User"
        }
        print(session["user"])
        return redirect(url_for("homePage"))
    else:
        return render_template("auth/login.html")


@app.route("/logout", methods = ["POST"])
def logout():
    session["user"] = {}
    return redirect(url_for("homePage"))


if __name__ == "__main__":
    app.run(debug = True)
    