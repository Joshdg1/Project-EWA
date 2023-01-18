import View from './View.vue'

describe('<View />', () => {
    it('renders properly', () => {
        // see: https://on.cypress.io/mounting-vue
        cy.mount(View)
        cy.get(".card").should("exist");
        cy.get(".card-toolbar").should("exist");

    //     const mockedResponse = [
    //         {
    //             id: 1,
    //             email: "kickooteman@gmail.com",
    //             firstName: "kick",
    //             lastName: "ooteman",
    //             description: "Lorum ipsum",
    //             endDate: "2023-01-13T00:00:00.000+00:00",
    //             startDate: "2022-12-26T00:00:00.000+00:00",
    //             title: "EWA"
    //         },
    //         {
    //             id: 2,
    //             email: "kickooteman@gmail.com",
    //             firstName: "kick",
    //             lastName: "ooteman",
    //             description: "Lorum ipsum",
    //             endDate: "2023-01-13T00:00:00.000+00:00",
    //             startDate: "2022-12-26T00:00:00.000+00:00",
    //             title: "EWA"
    //         },
    //         {
    //             id: 3,
    //             email: "kickooteman@gmail.com",
    //             firstName: "kick",
    //             lastName: "ooteman",
    //             description: "Lorum ipsum",
    //             endDate: "2023-01-13T00:00:00.000+00:00",
    //             startDate: "2022-12-26T00:00:00.000+00:00",
    //             title: "EWA"
    //         }
    //     ];
    //
    //     cy.intercept('GET', '/projects', {
    //         statusCode: 200,
    //         body: mockedResponse
    //     }).as('specificData');
    //
    //     cy.wait("@specificData");
    })
})