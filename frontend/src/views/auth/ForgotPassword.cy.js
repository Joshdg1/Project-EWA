import ForgotPassword from './ForgotPassword.vue'

describe('<ForgotPassword />', () => {
    it('renders', () => {
        // see: https://on.cypress.io/mounting-vue
        cy.mount(ForgotPassword)
    });

    it('load all content', () => {
        // see: https://on.cypress.io/mounting-vue
        cy.mount(ForgotPassword)

        cy.get('#email').should("exist");
        cy.get('.indicator-label').should("exist");
        cy.get('.text-center.mb-10 > .link-primary').should("exist");
    });

    it('can type', () => {
        // see: https://on.cypress.io/mounting-vue
        cy.mount(ForgotPassword)

        cy.get('#email').type("kickooteman@gmail.com");
    });


})