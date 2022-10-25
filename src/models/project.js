export class project{
    id;
    title;
    description;


    constructor(id, title, description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

   static fakeData(){

        let titleOptions = ["test 1", "test 2", "test 3"];
        let descriptionOptions = ["Description 1", "Description 2", "Description 3"];
        this.id = Math.random();
        this.title = titleOptions[Math.floor((Math.random()*3))];
        this.description = descriptionOptions[Math.floor((Math.random()*3))];

        return new project(this.id, this.title, this.description);
    }
}