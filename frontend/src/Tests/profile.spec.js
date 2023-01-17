
import profileDetails from "@/components/programmerProfile/ProfileDetails.vue"

import {mount} from '@vue/test-utils'

it('should Check if edeting is possible', function () {

    const wrapperDetails = mount(profileDetails)
    // const wrapperInputDetails = mount(profileInputDetails)
    expect(wrapperDetails.text()).toContain('Wijzigen')

});

