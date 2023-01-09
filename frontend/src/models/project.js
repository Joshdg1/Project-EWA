export class Project {
    id;
    title;
    description;
    company;
    startDate
    users
    hoursWorked;

    constructor(id, title, description, company, startDate, users, hoursWorked) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.company = company;
        this.startDate = startDate
        this.users = users
        this.hoursWorked = hoursWorked;
    }

    static fakeData() {

        let titleOptions = ["Very good project", "Even better project", "Amazing project"];
        let descriptionOptions = ["The project consists of a lot of stuff", "The project consists of very easy stuff", "The project consists of amazing easy stuff"];
        let companyOptions = ["Florijn is de beste", "Florijn is geweldig", "Florijn neem mij alsjeblieft aan als programmeur"];
        this.id = Math.floor(Math.random() * 100);
        this.title = titleOptions[Math.floor((Math.random() * 3))];
        this.description = descriptionOptions[Math.floor((Math.random() * 3))];
        this.company = companyOptions[Math.floor((Math.random() * 3))];
        this.hoursWorked = Math.floor((Math.random() * 3));

        return new Project(this.id, this.title, this.description, this.company, this.hoursWorked);

    }
}