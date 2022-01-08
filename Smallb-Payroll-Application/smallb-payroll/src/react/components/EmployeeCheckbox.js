/* The Employee Checkbox component contains a basic checkbos with the employee's information that is to be used by the
AddPayPeriod component to choose which employees to create timecards for in the new pay period. */
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
