import {Project} from "./project.js"

title, description, company, startDate, endDate, users, hoursWorked

const PROJECT_ID = 8;
const PROJECT_TITLE = "EWA";
const PROJECT_DESCRIPTION = "Big project";
const PROJECT_COMPANY = "HVA";
const PROJECT_STARTDATE = '14-01-2023';
const PROJECT_ENDDATE = '18-01-2023';
const PROJECT_USERS = "FLORIJN";
const PROJECT_HOURSWORKED = 40;

let project, project2;

beforeEach(function () {
    project = new Project(PROJECT_ID, PROJECT_TITLE, PROJECT_DESCRIPTION, PROJECT_COMPANY, PROJECT_STARTDATE,
        PROJECT_ENDDATE, PROJECT_USERS, PROJECT_HOURSWORKED);
    project2 = Project.fakeData();
});

it('should check if the title is correct', function () {
    expect(project.title).toBe("EWA")
});