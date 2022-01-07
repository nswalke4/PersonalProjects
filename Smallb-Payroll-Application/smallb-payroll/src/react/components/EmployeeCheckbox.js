const EmployeeCheckbox = ({ employee, index, onChange }) => {
    return (
        <div className="employee-checkbox">
            <label>
                <input
                    name="employee-checkbox-input"
                    type="checkbox"
                    value={index}
                    onChange={() => onChange(index)}
                />
                {employee.firstName} {employee.lastName}
            </label>
        </div>
    );
};

export default EmployeeCheckbox;
