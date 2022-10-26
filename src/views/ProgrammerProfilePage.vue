<template>
<!--  <div class="wrapper">-->

<!--    <div class="initialInfo">-->
<!--      <img class="profilePic" src="../assets/dummy-avatar-2772343867.png">-->
<!--      <div class="TextProgrammerInitialInfo">-->
<!--        <h5> {{ sampleProgrammer.firstname }} {{ sampleProgrammer.lastname }}</h5>-->
<!--        <p>Programmer</p>-->
<!--      </div>-->
<!--    </div>-->

<!--    <div>-->
<!--      <div class="uploadBox">-->
<!--        <div class="parent-div">-->
<!--          <button class="btn-upload">upload CV</button>-->
<!--          <input type="file" name="upfile">-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->

<!--    <div>-->
<!--      <div class="inputBoxesProgrammerProfile">-->
<!--        <div class="topInputBoxes">-->
<!--          <div class="leftInputBoxes">-->
<!--            <div class="editProfileText">-->
<!--              <h4> Edit your profile</h4>-->
<!--            </div>-->

<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel"> Adres:</label>-->
<!--              <input v-model="sampleProgrammer.address" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel">Experience:</label>-->
<!--              <input v-model="sampleProgrammer.experience" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel">Availability:</label>-->
<!--              <input v-model="sampleProgrammer.availability" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel">Current Project:</label>-->
<!--              <input v-model="sampleProgrammer.projectTypes" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel">Total Hours</label>-->
<!--              <input v-model="sampleProgrammer.hours" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--          </div>-->

<!--          <div class="rightInputBoxes">-->
<!--            <div style="opacity: 0">&#45;&#45;&#45;&#45;</div>-->
<!--            <div class="inputProgrammer">-->
<!--              <label class="InputLabel">Work Preference:-->
<!--                <button class="workPreferencebutton" @click="workPreferenceHome()" >Work from home</button>-->
<!--                <button class="workPreferencebutton" @click="workPreferenceLoc()"> Work on location</button>-->
<!--              </label>-->
<!--              <input v-model="sampleProgrammer.workPreference" class="ProgrammerProfileInputBox">-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="submitBox">-->
<!--      <button class="submitChanges" @click="submit()">Submit changes</button>-->
<!--    </div>-->

<!--  </div>-->
  <div class="container-xxl" id="kt_content_container">
  <div class="card mb-5 mb-xl-10">
    <div class="card-body pt-9 pb-0">
      <!--begin::Details-->
      <div class="d-flex flex-wrap flex-sm-nowrap mb-3">
        <!--begin: Pic-->
        <div class="me-7 mb-4">
          <div class="symbol symbol-100px symbol-lg-160px symbol-fixed position-relative">
            <img src="assets/media/avatars/150-2.jpg" alt="image" />
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
                <a href="#" class="text-gray-800 text-hover-primary fs-2 fw-bolder me-1">{{sampleProgrammer.firstname}} {{sampleProgrammer.lastname}}</a>


              </div>
              <!--end::Name-->
              <!--begin::Info-->
              <div class="d-flex flex-wrap fw-bold fs-6 mb-4 pe-2">
                <a href="#" class="d-flex align-items-center text-gray-400 text-hoveFr-primary me-5 mb-2">
                  <!--begin::Svg Icon | path: icons/duotune/communication/com006.svg-->
                  <span class="svg-icon svg-icon-4 me-1">
															<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																<path opacity="0.3" d="M22 12C22 17.5 17.5 22 12 22C6.5 22 2 17.5 2 12C2 6.5 6.5 2 12 2C17.5 2 22 6.5 22 12ZM12 7C10.3 7 9 8.3 9 10C9 11.7 10.3 13 12 13C13.7 13 15 11.7 15 10C15 8.3 13.7 7 12 7Z" fill="black" />
																<path d="M12 22C14.6 22 17 21 18.7 19.4C17.9 16.9 15.2 15 12 15C8.8 15 6.09999 16.9 5.29999 19.4C6.99999 21 9.4 22 12 22Z" fill="black" />
															</svg>
														</span>
                  <!--end::Svg Icon-->Developer</a>
                <a href="#" class="d-flex align-items-center text-gray-400 text-hover-primary me-5 mb-2">
                  <!--begin::Svg Icon | path: icons/duotune/general/gen018.svg-->
                  <span class="svg-icon svg-icon-4 me-1">
															<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																<path opacity="0.3" d="M18.0624 15.3453L13.1624 20.7453C12.5624 21.4453 11.5624 21.4453 10.9624 20.7453L6.06242 15.3453C4.56242 13.6453 3.76242 11.4453 4.06242 8.94534C4.56242 5.34534 7.46242 2.44534 11.0624 2.04534C15.8624 1.54534 19.9624 5.24534 19.9624 9.94534C20.0624 12.0453 19.2624 13.9453 18.0624 15.3453Z" fill="black" />
																<path d="M12.0624 13.0453C13.7193 13.0453 15.0624 11.7022 15.0624 10.0453C15.0624 8.38849 13.7193 7.04535 12.0624 7.04535C10.4056 7.04535 9.06241 8.38849 9.06241 10.0453C9.06241 11.7022 10.4056 13.0453 12.0624 13.0453Z" fill="black" />
															</svg>
														</span>
                  <!--end::Svg Icon-->{{ sampleProgrammer.city }}</a>
                <a href="#" class="d-flex align-items-center text-gray-400 text-hover-primary mb-2">
                  <!--begin::Svg Icon | path: icons/duotune/communication/com011.svg-->
                  <span class="svg-icon svg-icon-4 me-1">
															<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																<path opacity="0.3" d="M21 19H3C2.4 19 2 18.6 2 18V6C2 5.4 2.4 5 3 5H21C21.6 5 22 5.4 22 6V18C22 18.6 21.6 19 21 19Z" fill="black" />
																<path d="M21 5H2.99999C2.69999 5 2.49999 5.10005 2.29999 5.30005L11.2 13.3C11.7 13.7 12.4 13.7 12.8 13.3L21.7 5.30005C21.5 5.10005 21.3 5 21 5Z" fill="black" />
															</svg>
														</span>
                  <!--end::Svg Icon-->max@HvA.com</a>
              </div>
              <!--end::Info-->
            </div>
            <!--end::User-->
            <!--begin::Actions-->
            <div class="d-flex my-2">
              <a href="#" class="btn btn-light me-3" id="kt_user_follow_button">
                <!--begin::Svg Icon | path: icons/duotune/arrows/arr012.svg-->
                <span class="svg-icon svg-icon-3 d-none">
															<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																<path opacity="0.3" d="M10 18C9.7 18 9.5 17.9 9.3 17.7L2.3 10.7C1.9 10.3 1.9 9.7 2.3 9.3C2.7 8.9 3.29999 8.9 3.69999 9.3L10.7 16.3C11.1 16.7 11.1 17.3 10.7 17.7C10.5 17.9 10.3 18 10 18Z" fill="black" />
																<path d="M10 18C9.7 18 9.5 17.9 9.3 17.7C8.9 17.3 8.9 16.7 9.3 16.3L20.3 5.3C20.7 4.9 21.3 4.9 21.7 5.3C22.1 5.7 22.1 6.30002 21.7 6.70002L10.7 17.7C10.5 17.9 10.3 18 10 18Z" fill="black" />
															</svg>
														</span>
                <!--end::Svg Icon-->
<!--                &lt;!&ndash;begin::Indicator&ndash;&gt;-->
<!--                <span class="indicator-label">Follow</span>-->
                <span class="indicator-progress">Please wait...
														<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                <!--end::Indicator-->
              </a>

              <!--begin::Menu-->
<!--              <div class="me-0">-->
<!--                <button class="btn btn-icon btn-bg-light btn-active-color-primary" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end">-->
<!--                  <i class="bi bi-three-dots fs-3"></i>-->
<!--                </button>-->
<!--                &lt;!&ndash;begin::Menu 3&ndash;&gt;-->
<!--                <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg-light-primary fw-bold w-200px py-3" data-kt-menu="true">-->
<!--                  &lt;!&ndash;begin::Heading&ndash;&gt;-->
<!--                  <div class="menu-item px-3">-->
<!--                    <div class="menu-content text-muted pb-2 px-3 fs-7 text-uppercase">Payments</div>-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Heading&ndash;&gt;-->
<!--                  &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                  <div class="menu-item px-3">-->
<!--                    <a href="#" class="menu-link px-3">Create Invoice</a>-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                  &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                  <div class="menu-item px-3">-->
<!--                    <a href="#" class="menu-link flex-stack px-3">Create Payment-->
<!--                      <i class="fas fa-exclamation-circle ms-2 fs-7" data-bs-toggle="tooltip" title="Specify a target name for future usage and reference"></i></a>-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                  &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                  <div class="menu-item px-3">-->
<!--                    <a href="#" class="menu-link px-3">Generate Bill</a>-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                  &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                  <div class="menu-item px-3" data-kt-menu-trigger="hover" data-kt-menu-placement="right-end">-->
<!--                    <a href="#" class="menu-link px-3">-->
<!--                      <span class="menu-title">Subscription</span>-->
<!--                      <span class="menu-arrow"></span>-->
<!--                    </a>-->
<!--                    &lt;!&ndash;begin::Menu sub&ndash;&gt;-->
<!--                    <div class="menu-sub menu-sub-dropdown w-175px py-4">-->
<!--                      &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                      <div class="menu-item px-3">-->
<!--                        <a href="#" class="menu-link px-3">Plans</a>-->
<!--                      </div>-->
<!--                      &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                      &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                      <div class="menu-item px-3">-->
<!--                        <a href="#" class="menu-link px-3">Billing</a>-->
<!--                      </div>-->
<!--                      &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                      &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                      <div class="menu-item px-3">-->
<!--                        <a href="#" class="menu-link px-3">Statements</a>-->
<!--                      </div>-->
<!--                      &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                      &lt;!&ndash;begin::Menu separator&ndash;&gt;-->
<!--                      <div class="separator my-2"></div>-->
<!--                      &lt;!&ndash;end::Menu separator&ndash;&gt;-->
<!--                      &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                      <div class="menu-item px-3">-->
<!--                        <div class="menu-content px-3">-->
<!--                          &lt;!&ndash;begin::Switch&ndash;&gt;-->
<!--                          <label class="form-check form-switch form-check-custom form-check-solid">-->
<!--                            &lt;!&ndash;begin::Input&ndash;&gt;-->
<!--                            <input class="form-check-input w-30px h-20px" type="checkbox" value="1" checked="checked" name="notifications" />-->
<!--                            &lt;!&ndash;end::Input&ndash;&gt;-->
<!--                            &lt;!&ndash;end::Label&ndash;&gt;-->
<!--                            <span class="form-check-label text-muted fs-6">Recuring</span>-->
<!--                            &lt;!&ndash;end::Label&ndash;&gt;-->
<!--                          </label>-->
<!--                          &lt;!&ndash;end::Switch&ndash;&gt;-->
<!--                        </div>-->
<!--                      </div>-->
<!--                      &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                    </div>-->
<!--                    &lt;!&ndash;end::Menu sub&ndash;&gt;-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                  &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                  <div class="menu-item px-3 my-1">-->
<!--                    <a href="#" class="menu-link px-3">Settings</a>-->
<!--                  </div>-->
<!--                  &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--                </div>-->
<!--                &lt;!&ndash;end::Menu 3&ndash;&gt;-->
<!--              </div>-->
<!--              &lt;!&ndash;end::Menu&ndash;&gt;-->
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
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																		<rect opacity="0.5" x="13" y="6" width="13" height="2" rx="1" transform="rotate(90 13 6)" fill="black" />
																		<path d="M12.5657 8.56569L16.75 12.75C17.1642 13.1642 17.8358 13.1642 18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25L12.7071 5.70711C12.3166 5.31658 11.6834 5.31658 11.2929 5.70711L5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75C6.16421 13.1642 6.83579 13.1642 7.25 12.75L11.4343 8.56569C11.7467 8.25327 12.2533 8.25327 12.5657 8.56569Z" fill="black" />
																	</svg>
																</span>
                    <!--end::Svg Icon-->
                    <div class="fs-2 fw-bolder" data-kt-countup="true" data-kt-countup-value="56" data-kt-countup-prefix="">0</div>
                  </div>
                  <!--end::Number-->
                  <!--begin::Label-->
                  <div class="fw-bold fs-6 text-gray-400">Total Projects</div>
                  <!--end::Label-->
                </div>
                <!--end::Stat-->
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                  <!--begin::Number-->
                  <div class="d-flex align-items-center">
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr065.svg-->
                    <span class="svg-icon svg-icon-3 svg-icon-danger me-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																		<rect opacity="0.5" x="11" y="18" width="13" height="2" rx="1" transform="rotate(-90 11 18)" fill="black" />
																		<path d="M11.4343 15.4343L7.25 11.25C6.83579 10.8358 6.16421 10.8358 5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75L11.2929 18.2929C11.6834 18.6834 12.3166 18.6834 12.7071 18.2929L18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25C17.8358 10.8358 17.1642 10.8358 16.75 11.25L12.5657 15.4343C12.2533 15.7467 11.7467 15.7467 11.4343 15.4343Z" fill="black" />
																	</svg>
																</span>
                    <!--end::Svg Icon-->
                    <div class="fs-2 fw-bolder" data-kt-countup="true" data-kt-countup-value="2">0</div>
                  </div>
                  <!--end::Number-->
                  <!--begin::Label-->
                  <div class="fw-bold fs-6 text-gray-400">Current Projects</div>
                  <!--end::Label-->
                </div>
                <!--end::Stat-->
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                  <!--begin::Number-->
                  <div class="d-flex align-items-center">
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr066.svg-->
                    <span class="svg-icon svg-icon-3 svg-icon-success me-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																		<rect opacity="0.5" x="13" y="6" width="13" height="2" rx="1" transform="rotate(90 13 6)" fill="black" />
																		<path d="M12.5657 8.56569L16.75 12.75C17.1642 13.1642 17.8358 13.1642 18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25L12.7071 5.70711C12.3166 5.31658 11.6834 5.31658 11.2929 5.70711L5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75C6.16421 13.1642 6.83579 13.1642 7.25 12.75L11.4343 8.56569C11.7467 8.25327 12.2533 8.25327 12.5657 8.56569Z" fill="black" />
																	</svg>
																</span>
                    <!--end::Svg Icon-->
                    <div class="fs-2 fw-bolder" data-kt-countup="true" data-kt-countup-value="113" data-kt-countup-prefix="Hours: ">0</div>
                  </div>
                  <!--end::Number-->
                  <!--begin::Label-->
                  <div class="fw-bold fs-6 text-gray-400">Average time spent on Project</div>
                  <!--end::Label-->
                </div>
                <!--end::Stat-->
              </div>
              <!--end::Stats-->
            </div>
            <!--end::Wrapper-->
            <!--begin::Progress-->
            <div class="d-flex align-items-center w-200px w-sm-300px flex-column mt-3">
              <div class="d-flex justify-content-between w-100 mt-auto mb-2">
                <span class="fw-bold fs-6 text-gray-400">Hours still available</span>
                <span class="fw-bolder fs-6">20 hours</span>
              </div>
              <div class="h-5px mx-3 w-100 bg-light mb-3">
                <div class="bg-success rounded h-5px" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
            </div>
            <!--end::Progress-->
          </div>
          <!--end::Stats-->
        </div>
        <!--end::Info-->
      </div>
      <!--end::Details-->
      <!--begin::Navs-->
      <div class="d-flex overflow-auto h-10px">
<!--        <ul class="nav nav-stretch nav-line-tabs nav-line-tabs-2x border-transparent fs-5 fw-bolder flex-nowrap">-->
<!--          &lt;!&ndash;begin::Nav item&ndash;&gt;-->
<!--          <li class="nav-item">-->
<!--            <a class="nav-link text-active-primary me-6 active" href="../dist/account/overview.html">Overview</a>-->
<!--          </li>-->
<!--          &lt;!&ndash;end::Nav item&ndash;&gt;-->
<!--          &lt;!&ndash;begin::Nav item&ndash;&gt;-->
<!--          <li class="nav-item">-->
<!--            <a class="nav-link text-active-primary me-6" href="#">Settings</a>-->
<!--          </li>-->
<!--          &lt;!&ndash;end::Nav item&ndash;&gt;-->
<!--          &lt;!&ndash;begin::Nav item&ndash;&gt;-->
<!--          <li class="nav-item">-->
<!--            <a class="nav-link text-active-primary me-6" href="#">Security</a>-->
<!--          </li>-->
<!--          &lt;!&ndash;end::Nav item&ndash;&gt;-->
<!--          &lt;!&ndash;begin::Nav item&ndash;&gt;-->
<!--          <li class="nav-item">-->
<!--            <a class="nav-link text-active-primary me-6" href="#">Audit Logs</a>-->
<!--          </li>-->
<!--          &lt;!&ndash;end::Nav item&ndash;&gt;-->
<!--          &lt;!&ndash;begin::Nav item&ndash;&gt;-->
<!--          <li class="nav-item">-->
<!--            <a class="nav-link text-active-primary me-6" href="#">Activity</a>-->
<!--          </li>-->
<!--          &lt;!&ndash;end::Nav item&ndash;&gt;-->
<!--        </ul>-->
      </div>
      <!--begin::Navs-->
    </div>
  </div>
  <!--end::Navbar-->
  <!--begin::details View-->

  <div v-if="this.editProfile === true" class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Profile Details</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
        <a @click="toProfileDetails()" class="btn background-florijn btn-active-info" tooltip="New App" data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Save profile-page</a>
      </div>
      <!--end::Action-->
    </div>
    <!--begin::Card header-->
    <!--begin::Card body-->
    <div class="card-body p-9">
      <!--begin::Row-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Full Name</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid " id="fullNameLeft" name="search" v-model="sampleProgrammer.firstname" data-kt-search-element="input" />
            <input type="text" class="form-control form-control-solid " id="fullNameRight" name="search" v-model="sampleProgrammer.lastname" data-kt-search-element="input" />
          </div>

        </div>
        <!--end::Col-->
      </div>
      <!--end::Row-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Availability</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.availability" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Address
<!--          <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Phone number must be active"></i>-->
        </label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 d-flex align-items-center">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.address" data-kt-search-element="input" />
<!--          <span class="badge badge-success">Verified</span>-->
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Type of Projects</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.projectTypes" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Knowledge
          <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Programming Languages Known"></i></label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.knowledge" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Experience</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.experience" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-10">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Work preference</label>
        <!--begin::Label-->
        <!--begin::Label-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.workPreference" data-kt-search-element="input" />
        </div>
        <!--begin::Label-->
      </div>
      <!--end::Input group-->
      <!--begin::Notice-->
<!--      <div class="notice d-flex bg-light-warning rounded border-warning border border-dashed p-6">-->
<!--        &lt;!&ndash;begin::Icon&ndash;&gt;-->
<!--        &lt;!&ndash;begin::Svg Icon | path: icons/duotune/general/gen044.svg&ndash;&gt;-->
<!--        <span class="svg-icon svg-icon-2tx svg-icon-warning me-4">-->
<!--											<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">-->
<!--												<rect opacity="0.3" x="2" y="2" width="20" height="20" rx="10" fill="black" />-->
<!--												<rect x="11" y="14" width="7" height="2" rx="1" transform="rotate(-90 11 14)" fill="black" />-->
<!--												<rect x="11" y="17" width="2" height="2" rx="1" transform="rotate(-90 11 17)" fill="black" />-->
<!--											</svg>-->
<!--										</span>-->
<!--        &lt;!&ndash;end::Svg Icon&ndash;&gt;-->
<!--        &lt;!&ndash;end::Icon&ndash;&gt;-->
<!--        &lt;!&ndash;begin::Wrapper&ndash;&gt;-->
<!--        <div class="d-flex flex-stack flex-grow-1">-->
<!--          &lt;!&ndash;begin::Content&ndash;&gt;-->
<!--          <div class="fw-bold">-->
<!--            <h4 class="text-gray-900 fw-bolder">We need your attention!</h4>-->
<!--            <div class="fs-6 text-gray-700">Your payment was declined. To start using tools, please-->
<!--              <a class="fw-bolder" href="#">Add Payment Method</a>.</div>-->
<!--          </div>-->
<!--          &lt;!&ndash;end::Content&ndash;&gt;-->
<!--        </div>-->
<!--        &lt;!&ndash;end::Wrapper&ndash;&gt;-->
<!--      </div>-->
      <!--end::Notice-->
    </div>
    <!--end::Card body-->
  </div>

    <div v-if="!this.editProfile" class="card mb-5 mb-xl-10" id="kt_profile_details_view">
      <!--begin::Card header-->
      <div class="card-header cursor-pointer">
        <!--begin::Card title-->
        <div class="card-title m-0">
          <h3 class="fw-bolder m-0">Profile Details</h3>
        </div>
        <!--end::Card title-->
        <!--begin::Action-->
        <div class="d-flex ms-3">
          <a @click="toEditProfile()" class="btn background-florijn btn-active-info" tooltip="New App" data-bs-toggle="modal"
             data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit profile-page</a>
        </div>
        <!--end::Action-->
      </div>
      <!--begin::Card header-->
      <!--begin::Card body-->
      <div class="card-body p-9">
        <!--begin::Row-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Full Name</label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8">
            <span class="fw-bolder fs-6 text-gray-800">{{sampleProgrammer.firstname}} {{sampleProgrammer.lastname}}</span>
          </div>
          <!--end::Col-->
        </div>
        <!--end::Row-->
        <!--begin::Input group-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Availability</label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8 fv-row">
            <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.availability }}</span>
          </div>
          <!--end::Col-->
        </div>
        <!--end::Input group-->
        <!--begin::Input group-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Address
<!--            <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Phone number must be active"></i>-->
          </label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8 d-flex align-items-center">
            <span class="fw-bolder fs-6 me-2 text-gray-800">{{ sampleProgrammer.address }}</span>
            <!--          <span class="badge badge-success">Verified</span>-->
          </div>
          <!--end::Col-->
        </div>
        <!--end::Input group-->
        <!--begin::Input group-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Type of Projects</label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8">
            <a href="#" class="fw-bold fs-6 text-gray-800 text-hover-primary">{{ sampleProgrammer.projectTypes }}</a>
          </div>
          <!--end::Col-->
        </div>
        <!--end::Input group-->
        <!--begin::Input group-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Knowledge
            <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Programming languages known"></i></label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8">
            <span class="fw-bolder fs-6 text-gray-800">{{ sampleProgrammer.knowledge }}</span>
          </div>
          <!--end::Col-->
        </div>
        <!--end::Input group-->
        <!--begin::Input group-->
        <div class="row mb-7">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Experience</label>
          <!--end::Label-->
          <!--begin::Col-->
          <div class="col-lg-8">
            <span class="fw-bolder fs-6 text-gray-800">{{ sampleProgrammer.experience }}</span>
          </div>
          <!--end::Col-->
        </div>
        <!--end::Input group-->
        <!--begin::Input group-->
        <div class="row mb-10">
          <!--begin::Label-->
          <label class="col-lg-4 fw-bold text-muted">Work preference</label>
          <!--begin::Label-->
          <!--begin::Label-->
          <div class="col-lg-8">
            <span class="fw-bold fs-6">{{ sampleProgrammer.workPreference }}</span>
          </div>
          <!--begin::Label-->
        </div>
        <!--end::Input group-->
        <!--begin::Notice-->
        <!--      <div class="notice d-flex bg-light-warning rounded border-warning border border-dashed p-6">-->
        <!--        &lt;!&ndash;begin::Icon&ndash;&gt;-->
        <!--        &lt;!&ndash;begin::Svg Icon | path: icons/duotune/general/gen044.svg&ndash;&gt;-->
        <!--        <span class="svg-icon svg-icon-2tx svg-icon-warning me-4">-->
        <!--											<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">-->
        <!--												<rect opacity="0.3" x="2" y="2" width="20" height="20" rx="10" fill="black" />-->
        <!--												<rect x="11" y="14" width="7" height="2" rx="1" transform="rotate(-90 11 14)" fill="black" />-->
        <!--												<rect x="11" y="17" width="2" height="2" rx="1" transform="rotate(-90 11 17)" fill="black" />-->
        <!--											</svg>-->
        <!--										</span>-->
        <!--        &lt;!&ndash;end::Svg Icon&ndash;&gt;-->
        <!--        &lt;!&ndash;end::Icon&ndash;&gt;-->
        <!--        &lt;!&ndash;begin::Wrapper&ndash;&gt;-->
        <!--        <div class="d-flex flex-stack flex-grow-1">-->
        <!--          &lt;!&ndash;begin::Content&ndash;&gt;-->
        <!--          <div class="fw-bold">-->
        <!--            <h4 class="text-gray-900 fw-bolder">We need your attention!</h4>-->
        <!--            <div class="fs-6 text-gray-700">Your payment was declined. To start using tools, please-->
        <!--              <a class="fw-bolder" href="#">Add Payment Method</a>.</div>-->
        <!--          </div>-->
        <!--          &lt;!&ndash;end::Content&ndash;&gt;-->
        <!--        </div>-->
        <!--        &lt;!&ndash;end::Wrapper&ndash;&gt;-->
        <!--      </div>-->
        <!--end::Notice-->
      </div>
      <!--end::Card body-->
    </div>
  <!--end::details View-->
  </div>
</template>

<script>
import {Programmer} from "@/models/programmer";

export default {
  name: "ProgrammerProfilePage",

  created() {
    this.sampleProgrammer = new Programmer("John", "Doe", "wiboutStraat","Amsterdam", "js Cobol", 40, 12,20, "On location", "EWA")

  },
  data() {
    return {
      sampleProgrammer: null,
      editProfile: null

    }
  },
  methods: {
    submit(){
      console.log("twekrt")
      alert(
        "Firstname: "+   this.sampleProgrammer.firstname + "\n"+
          "lastname: "+    this.sampleProgrammer.lastname + "\n"+
          "Address: "+   this.sampleProgrammer.address + "\n"+
          "Experience: "+    this.sampleProgrammer.experience + "\n"+
          "Availability: "+    this.sampleProgrammer.availability + "\n"+
          "CurrentProject: "+    this.sampleProgrammer.projectTypes + "\n"+
          "TotalHours: "+    this.sampleProgrammer.hours + "\n"+
          "WorkPreference: "+    this.sampleProgrammer.workPreference + "\n"
      )
    },
    toEditProfile(){
      this.editProfile = true;


    },
    toProfileDetails(){
      this.editProfile = false;


    },
  }
}

</script>

<style scoped>


.parent-div input[type=file] {
  left: 0;
  top: 0;
  opacity: 0;
  position: absolute;
  font-size: 90px;
}


.fullNameInput{
  display: flex;
  flex-direction: row;
}
#fullNameLeft {
  width: 15vw !important;
  margin-right:.5em;
}
#fullNameRight {
  width: 15vw !important;
}
</style>