from flask import Flask, render_template, request, url_for, session, redirect, flash
from datetime import timedelta


app = Flask(__name__)
app.secret_key = "12345678"
app.permanent_session_lifetime = timedelta(days = 1)


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
        
        session.permanent = True
        session["user"] = {
            "email": email,
            "name": "Fake User"
        }
        flash("Login success", category="info")
        return redirect(url_for("homePage"))
    else:
        if "user" in session and "email" in session["user"]:
            return redirect(url_for("homePage"))
        return render_template("auth/login.html")


@app.route("/logout", methods = ["POST"])
def logout():
    session.pop("user", None)
    return redirect(url_for("homePage"))


if __name__ == "__main__":
    app.run(debug = True)
    