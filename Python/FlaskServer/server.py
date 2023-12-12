from flask import Flask

app = Flask(__name__)

# Sample data (in-memory storage)
data_store = {
    '1': {'name': 'John', 'age': 25},
    '2': {'name': 'Jane', 'age': 30}
}

##########################################################################
# GET Requests
##########################################################################

# Root GET Request
@app.route('/')
def hello_world():
    return 'Hello, Flask!'

# GET request to retrieve all data
@app.route('/data', methods=['GET'])
def get_all_data():
    return jsonify(data_store)

# GET request to retrieve a specific item
@app.route('/data/<item_id>', methods=['GET'])
def get_single_data(item_id):
    if item_id in data_store:
        return jsonify(data_store[item_id])
    else:
        return jsonify({'error': 'Item not found'}), 404

##########################################################################
# POST Requests
##########################################################################

# POST request to add a new item
@app.route('/data', methods=['POST'])
def add_data():
    new_data = request.get_json()
    item_id = str(len(data_store) + 1)
    data_store[item_id] = new_data
    return jsonify({'id': item_id, 'message': 'Item added successfully'}), 201

##########################################################################
# PUT Requests
##########################################################################

# PUT request to update an existing item
@app.route('/data/<item_id>', methods=['PUT'])
def update_data(item_id):
    if item_id in data_store:
        updated_data = request.get_json()
        data_store[item_id].update(updated_data)
        return jsonify({'message': f'Item {item_id} updated successfully'})
    else:
        return jsonify({'error': 'Item not found'}), 404

##########################################################################
# DELETE Requests
##########################################################################

# DELETE request to remove an item
@app.route('/data/<item_id>', methods=['DELETE'])
def delete_data(item_id):
    if item_id in data_store:
        del data_store[item_id]
        return jsonify({'message': f'Item {item_id} deleted successfully'})
    else:
        return jsonify({'error': 'Item not found'}), 404


##########################################################################
# Run Server
##########################################################################

if __name__ == '__main__':
    app.run(debug=True)
