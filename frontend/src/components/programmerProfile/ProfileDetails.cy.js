import ProfileDetails from './ProfileDetails.vue'
import User from "@/models/user";

beforeEach(() => {
  window.localStorage.clear();
  window.localStorage.setItem("id", "12");
  window.localStorage.setItem("firstName", "kick");
  window.localStorage.setItem("lastName", "ooteman");
  window.localStorage.setItem("email", "kickooteman@gmail.com");
  window.localStorage.setItem("userType", "administrator");
  const user = new User(12,"kick",'ooteman',"valentijnnijhuis@gmail.com","cv.png",12365449)
  sessionStorage.user = JSON.stringify({
    id: user.id,
    firstName: user.firstName,
    lastName: user.lastName,
    email: user.email,
    userType: user.phoneNumber,
  });


  Cypress.on('uncaught:exception', (err, runnable) => {
    // returning false here prevents Cypress from
    // failing the test
    return false
  })
})
describe('<ProfileDetails />',  () => {
  it('renders', () => {
    const user = new User(12,"kick",'ooteman',"valentijnnijhuis@gmail.com","cv.png",12365449)
    // see: https://on.cypress.io/mounting-vue
    cy.mount(ProfileDetails, { props: {
        sampleProgrammer: user,
      }})
  })
})