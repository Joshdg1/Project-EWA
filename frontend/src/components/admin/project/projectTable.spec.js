import { mount } from '@vue/test-utils'
import Table from  './Table'

let wrapper

beforeEach(function () {
   wrapper = mount(Table);
});

it('should render properly', function () {
    expect(wrapper.element.children.length).toBeGreatThan(0);
});