from flask import Blueprint, jsonify

category_bp = Blueprint('categories', __name__)

@category_bp.route('/categories')
def get_categories():
    data = [
        {
            "id": 1,
            "title": "Item 1"
        },
        {
            "id": 2,
            "title": "Item 2"
        }
    ];
    return jsonify(data)

@category_bp.route('/categories/<category_id>')
def get_category(category_id):
    data = {
        "id": 1,
        "title": "Item 1"
    };
    return jsonify(data)

@category_bp.errorhandler(404)
def not_found(error):
    return 'Category not found', 404