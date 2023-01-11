<template>
  <div class="card mb-5 pb-5 mb-xl-10">
    <div class="card-body pt-9 pb-0">
      <!--begin::Details-->
      <div class="close" @click="close">
        <span class="svg-icon svg-icon-1 ">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
									<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="black" />
									<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="black" />
								</svg>
							</span>
      </div>
      <div class="d-flex flex-wrap flex-sm-nowrap mb-3">
        <!--begin: Pic-->
        <div class="me-7 mb-4">
          <div class="symbol symbol-100px symbol-lg-160px symbol-fixed position-relative">
            <span class="fs-1 symbol-label bg-primary text-inverse-primary fw-bold">{{
                sampleProgrammer.title[0]
              }}</span>

            <!--            <div class="position-absolute translate-middle bottom-0 start-100 mb-6 bg-success rounded-circle border border-4 border-white h-20px w-20px"></div>-->
          </div>
        </div>

        <!--end::Pic-->
        <!--begin::Info-->
        <div class="flex-grow-1">
          <!--begin::Title-->
          <div class="d-flex justify-content-between align-items-start flex-wrap mb-2">
            <!--begin::User-->
            <div class="d-flex flex-column">
              <!--begin::Name-->
              <div class="d-flex align-items-center mb-2">
                <a href="#"
                   class="text-gray-800 text-hover-primary fs-2 fw-bolder me-1">{{ sampleProgrammer.title }}</a>


              </div>
              <!--end::Name-->
              <!--begin::Info-->
              <div class="d-flex flex-wrap fw-bold fs-6 mb-4 pe-2">
                <a href="#" class="d-flex align-items-center text-gray-400 text-hoveFr-primary me-5 mb-2">
                  <!--begin::Svg Icon | path: icons/duotune/communication/com006.svg-->
                  <span class="svg-icon svg-icon-4 me-1">
															<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                   fill="none">
																<path opacity="0.3"
                                      d="M22 12C22 17.5 17.5 22 12 22C6.5 22 2 17.5 2 12C2 6.5 6.5 2 12 2C17.5 2 22 6.5 22 12ZM12 7C10.3 7 9 8.3 9 10C9 11.7 10.3 13 12 13C13.7 13 15 11.7 15 10C15 8.3 13.7 7 12 7Z"
                                      fill="black"/>
																<path
                                    d="M12 22C14.6 22 17 21 18.7 19.4C17.9 16.9 15.2 15 12 15C8.8 15 6.09999 16.9 5.29999 19.4C6.99999 21 9.4 22 12 22Z"
                                    fill="black"/>
															</svg>
														</span>
                  <!--end::Svg Icon-->{{ newUser.companyName }}</a>

              </div>
              <!--end::Info-->
            </div>
            <!--end::User-->
            <!--begin::Actions-->
            <div class="d-flex my-2">
            </div>
            <!--end::Actions-->
          </div>
          <!--end::Title-->
          <!--begin::Stats-->
          <div class="d-flex flex-wrap flex-stack">
            <!--begin::Wrapper-->
            <div class="d-flex flex-column flex-grow-1 pe-8">
              <!--begin::Stats-->
              <div class="d-flex flex-wrap">
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                  <!--begin::Number-->
                  <div class="d-flex align-items-center">
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr066.svg-->
                    <span class="svg-icon svg-icon-3 svg-icon-success me-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<rect opacity="0.5" x="13" y="6" width="13" height="2" rx="1"
                                          transform="rotate(90 13 6)" fill="black"/>
																		<path
                                        d="M12.5657 8.56569L16.75 12.75C17.1642 13.1642 17.8358 13.1642 18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25L12.7071 5.70711C12.3166 5.31658 11.6834 5.31658 11.2929 5.70711L5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75C6.16421 13.1642 6.83579 13.1642 7.25 12.75L11.4343 8.56569C11.7467 8.25327 12.2533 8.25327 12.5657 8.56569Z"
                                        fill="black"/>
																	</svg>
																</span>
                    <!--end::Svg Icon-->
                    <div class="fs-2 fw-bolder" data-kt-countup="true" data-kt-countup-value="56"
                         data-kt-countup-prefix="">{{sampleProgrammer.hoursWorked}}
                    </div>
                  </div>
                  <!--end::Number-->
                  <!--begin::Label-->
                  <div class="fw-bold fs-6 text-gray-400">Totaal aantal uren</div>
                  <!--end::Label-->
                </div>
                <!--end::Stat-->
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                  <!--begin::Number-->
                  <div class="d-flex align-items-center">
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr065.svg-->
                    <span class="svg-icon svg-icon-3 svg-icon-danger me-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<rect opacity="0.5" x="11" y="18" width="13" height="2" rx="1"
                                          transform="rotate(-90 11 18)" fill="black"/>
																		<path
                                        d="M11.4343 15.4343L7.25 11.25C6.83579 10.8358 6.16421 10.8358 5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75L11.2929 18.2929C11.6834 18.6834 12.3166 18.6834 12.7071 18.2929L18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25C17.8358 10.8358 17.1642 10.8358 16.75 11.25L12.5657 15.4343C12.2533 15.7467 11.7467 15.7467 11.4343 15.4343Z"
                                        fill="black"/>
																	</svg>
																</span>
                    <!--end::Svg Icon-->
                    <div class="fs-2 fw-bolder" data-kt-countup="true" data-kt-countup-value="2">{{ sampleProgrammer.users.length }}</div>
                  </div>
                  <!--end::Number-->
                  <!--begin::Label-->
                  <div class="fw-bold fs-6 text-gray-400">Huidige specialisten aan project</div>
                  <!--end::Label-->
                </div>
                <!--end::Stat-->
                <!--begin::Stat-->
                <div class="">
                  <!--begin::Number-->

                  <!--end::Number-->
                  <!--begin::Label-->


                  <!--end::Label-->
                </div>
                <!--end::Stat-->
              </div>
              <!--end::Stats-->
            </div>
            <!--end::Wrapper-->
            <!--begin::Progress-->
            <!--end::Progress-->
          </div>
          <!--end::Stats-->
        </div>
        <!--end::Info-->
      </div>
      <!--end::Details-->
      <!--begin::Navs-->

      <div class="d-flex overflow-auto h-20px">
        <ul class="nav nav-stretch nav-line-tabs nav-line-tabs-2x border-transparent fs-5 fw-bolder flex-nowrap">

          <!--begin::Nav item-->
          <li class="nav-item">
            <a class="nav-link text-active-primary me-6 " id="Details" @click="setSelectedTabDetails">Informatie</a>
          </li>
          <!--end::Nav item-->
          <!--begin::Nav item-->
          <li class="nav-item" >
            <a class="nav-link text-active-primary me-6" v-if="userType === 'client'" id="hours" @click="setSelectedTabAvailability">Uren</a>
          </li>
          <!--end::Nav item-->

        </ul>
      </div>
      <!--begin::Navs-->
    </div>
  </div>
  <!--end::Navbar-->
</template>

<script>


import UserRepository from "@/repository/UserRepository";
import HourRepository from "@/repository/HourRepository";

export default {
  name: "TopProfileDetails",
  props: ['sampleProgrammer'],
  emits: ['selectedTab','close-detail'],
  async created() {
    this.selectedTab = 1;
    const el = document.getElementById('Details');
    if (el)
      el.classList.add("active")

    this.userType = this.user.userType
    console.log("USERTYPE" +this.userType)
    this.newUser = await this.userRepository.findUserById(this.user.id)



  },
  data() {
    return {
      selectedTab: null,
      userType: null,
      newUser: null,
      totalHours: 0,
      userRepository: new UserRepository(),
      hoursRepository: new HourRepository(),
      user: JSON.parse(sessionStorage.user),
    }
  },
  methods: {
    setSelectedTabAvailability() {
      const oldSelectedTab = this.selectedTab;
      this.selectedTab = 2
      const el = document.getElementById('hours');
      if (oldSelectedTab === 1) {
        const el2 = document.getElementById("Details")
        el2.classList.remove("active")
      }

      el.classList.add("active")

      this.$emit('selectedTab', this.selectedTab)
    },
    async translatedUserType() {
      const getUser = await this.userRepository.findUserById(this.user.id)
      return getUser.company.toString()
    },
    close(){
      this.$emit('close-detail' , false)
    },
    setSelectedTabDetails() {
      const oldSelectedTab = this.selectedTab;
      this.selectedTab = 1
      const el = document.getElementById('Details');
      if (oldSelectedTab === 2) {
        const el2 = document.getElementById("hours")
        el2.classList.remove("active")
      }

      el.classList.add("active")

      this.$emit('selectedTab', this.selectedTab)
    },

  },

}
</script>

<style scoped>
.close {
  display: flex;
  margin-left: 62vw;
  cursor: pointer;
}
</style>
