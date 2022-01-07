const AddTimecards = ({ payPeriodId, employees }) => {
    return (
        <div>
            <h3>Pay Period: {payPeriodId}</h3>
            {employees.map((emp) => {
                return (
                    <p>
                        {emp.firstName} {emp.lastName}
                    </p>
                );
            })}
        </div>
    );
};

export default AddTimecards;
