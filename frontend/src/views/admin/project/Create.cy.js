import Create from './Create.vue'

describe('<Create />', () => {

  beforeEach(() => {
    Cypress.on('uncaught:exception', (err, runnable) => {
      // returning false here prevents Cypress from
      // failing the test
      return false
    })
  })

  it('renders properly', () => {
    // see: https://on.cypress.io/mounting-vue
    cy.mount(Create)
  });

  it('Load content', () => {
    // see: https://on.cypress.io/mounting-vue
    cy.mount(Create)

    cy.get(".card").should("exist");
    cy.get(".card-footer").should("exist");
    cy.get("#fullName").should("exist");
    cy.get("#next").should("exist");
  });

  it('Show requirements', () => {
    // see: https://on.cypress.io/mounting-vue
    cy.mount(Create)

    cy.get("#next").trigger("click");

    cy.get(".text-danger").should("exist");
    
  });


  it('Should be abled to type', () => {
    // see: https://on.cypress.io/mounting-vue
    cy.mount(Create)

    cy.get("#fullName").type("Kick Ooteman", {force: true});
    cy.get("#description").type("Nice project!", {force: true});
  });

});