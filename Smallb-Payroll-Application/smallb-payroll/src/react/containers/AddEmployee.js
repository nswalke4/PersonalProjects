const AddEmployee = ({ onClose }) => {
    return (
        <div className="add-employee">
            <p>Add a new Employee here...</p>
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default AddEmployee;
