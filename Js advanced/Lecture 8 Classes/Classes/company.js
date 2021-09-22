class Company {
    constructor() {
        this.departments = {};
    }
    addEmployee(emplName, salary, position, department) {
        this.validate(emplName);
        this.validate(salary);
        this.validate(position);
        this.validate(department);
        salary = Number(salary);
        if (salary === 'NaN' || salary < 0) {
            throw new Error('Invalid input!');
        }

        let empl = { emplName, salary, position, department }
        if (!this.departments.hasOwnProperty(department)) {
            this.departments[department] = [];
        }
        this.departments[department].push(empl)
        return `New employee is hired. Name: ${emplName}. Position: ${position}`
    }
    bestDepartment() {
        let entries = Object.entries(this.departments);
        let sortedEntriesBySalary = entries.sort((a, b) => {
            let first = a[1].reduce((acc, x) => acc + x.salary, 0) / a[1].length;
            let second = b[1].reduce((acc, x) => acc + x.salary, 0) / b[1].length;

            return second - first;
        });
        let bestDepartment = sortedEntriesBySalary[0];
        let avrgSalary = sortedEntriesBySalary[0][1].reduce((acc, x) => acc + x.salary, 0) / sortedEntriesBySalary[0][1].length;
        let empls = sortedEntriesBySalary[0][1];
        empls.sort((a, b) => {
            if (a.salary - b.salary < 0) {
                return 1;
            } else if (a.salary - b.salary > 0) {
                return -1;
            } else {
                return a.emplName.localeCompare(b.emplName);
            }

        })
        let result = `Best Department is: ${bestDepartment[0]}\n`;
        result += `Average salary: ${avrgSalary.toFixed(2)}\n`;
        empls.forEach(element => {
            result += `${element.emplName} ${element.salary} ${element.position}\n`;
        });
        return result.trim();
    }
    validate(value) {
        if (value === '' || value === undefined || value === null) {
            throw new Error('Invalid input!');
        }
    }
}
let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Human resources");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());
