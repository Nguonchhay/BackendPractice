from flask import Blueprint, render_template, url_for, request, redirect

auth = Blueprint('auth', __name__)


@auth.route('/register')
def register_page():
    return render_template('register.html')


@auth.route('/signup', methods=['POST'])
def signup():
    fullname = request.form.get('fullname')
    email = request.form.get('email')
    password = request.form.get('password')

    print(fullname, email, password)

    return redirect(url_for('auth.login_page'))


@auth.route('/login')
def login_page():
    return render_template('login.html')


@auth.route('/login', methods=['POST'])
def login():
    email = request.form.get('email')
    password = request.form.get('password')

    print(email, password)

    return redirect(url_for('main.profile_page'))


@auth.route('/logout')
def logout_page():
    return 'Logout page'
