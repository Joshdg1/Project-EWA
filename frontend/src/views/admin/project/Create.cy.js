import Create from './Create.vue'

describe('<Create />', () => {
  it('renders properly', () => {
    // see: https://on.cypress.io/mounting-vue
    cy.mount(Create)

    cy.get(".card-footer").should("exist");
  })
})