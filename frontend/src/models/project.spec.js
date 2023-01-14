import {Project} from "./project.js"

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
    // Check if the created project is an actual project.
    expect(project).toBeInstanceOf(Project);

    //Check if all attributes are set correctly from creating a new project.
    expect(project.id).toBe(8);
    expect(project.title).toBe("EWA");
    expect(project.description).toBe("Big project");
    expect(project.company).toBe("HVA");
    expect(project.startDate).toBe("14-01-2023");
    expect(project.endDate).toBe("18-01-2023");
    expect(project.endDate).toBe("18-01-2023");
    expect(project.users).toBe("FLORIJN");
    expect(project.hoursWorked).toBe(40);
});