<template>
  <div id="kt_aside" class="aside aside-extended" data-kt-drawer="true" data-kt-drawer-name="aside"
       data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true" data-kt-drawer-width="70px"
       data-kt-drawer-direction="start" data-kt-drawer-toggle="#kt_aside_toggle">
    <!--begin::Primary-->
    <div class="aside-primary d-flex flex-column align-items-lg-center flex-row-auto">
      <!--begin::Logo-->
      <div class="aside-logo d-none d-lg-flex flex-column align-items-center flex-column-auto py-10" id="kt_aside_logo">
          <img @click="goToHome()" alt="Logo" src="/assets/media/logos/logo-default.svg" class="h-50px cursor-pointer"/>
      </div>
      <!--end::Logo-->
      <!--begin::Nav-->
      <div class="aside-nav d-flex flex-column align-items-center flex-column-fluid w-100 pt-5 pt-lg-0"
           id="kt_aside_nav">
        <!--begin::Wrapper-->
        <div class="hover-scroll-y mb-10" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}"
             data-kt-scroll-height="auto" data-kt-scroll-wrappers="#kt_aside_nav"
             data-kt-scroll-dependencies="#kt_aside_logo, #kt_aside_footer" data-kt-scroll-offset="0px">
          <!--begin::Nav-->
          <ul class="nav flex-column">
            <!--begin::Nav item-->
            <li class="nav-item mb-2" data-bs-toggle="tooltip" data-bs-trigger="hover" data-bs-placement="right"
                data-bs-dismiss="click" title="Projects">
              <!--begin::Nav link-->
              <div class="nav-link btn btn-custom btn-icon" data-bs-toggle="tab" @click="goToProjects()">
                <!--begin::Svg Icon | path: icons/duotune/abstract/abs042.svg-->
                <span class="svg-icon svg-icon-2x">
												<svg  version="1.0" xmlns="http://www.w3.org/2000/svg"
                             width="920.000000pt" height="768.000000pt" viewBox="0 0 920.000000 768.000000"
                             preserveAspectRatio="xMidYMid meet">

<g transform="translate(0.000000,768.000000) scale(0.100000,-0.100000)"
   fill="#EF5722" stroke="none">
<path d="M4162 7669 c-283 -38 -506 -145 -698 -334 -166 -164 -252 -319 -291
-525 l-17 -90 -506 0 c-563 0 -578 -2 -702 -67 -113 -59 -190 -163 -217 -291
-16 -75 -16 -4969 0 -5044 27 -128 108 -233 225 -295 124 -66 48 -63 1569 -63
l1380 0 -622 618 c-718 713 -678 663 -678 842 0 115 16 167 86 288 37 63 474
513 546 563 60 42 115 59 218 69 152 15 272 -22 443 -137 71 -48 126 -103 346
-343 144 -157 275 -300 291 -318 15 -17 31 -32 35 -32 5 0 340 355 471 500 12
14 50 54 83 90 34 36 113 121 176 190 63 68 178 192 255 275 290 312 363 391
403 436 l42 46 0 1131 c0 793 -3 1147 -11 1184 -37 173 -160 293 -354 343 -49
12 -142 15 -565 15 l-506 0 -17 90 c-39 206 -125 360 -291 525 -127 125 -227
190 -390 254 -152 60 -271 82 -466 86 -91 2 -198 -1 -238 -6z m335 -514 c225
-42 396 -199 497 -457 50 -128 86 -296 86 -405 l0 -53 508 0 c550 0 590 -4
692 -55 110 -56 194 -176 225 -324 8 -40 15 -79 15 -87 0 -12 -291 -14 -2161
-14 l-2161 0 7 53 c22 170 112 310 242 376 95 48 134 51 679 51 l510 0 17 133
c28 225 97 417 201 554 144 190 387 277 643 228z m-1498 -1891 c108 -32 172
-135 158 -254 -12 -98 -64 -162 -160 -194 -63 -21 -322 -22 -391 -2 -108 33
-161 106 -161 226 0 118 52 193 157 225 64 20 329 20 397 -1z m3115 2 c108
-33 161 -106 161 -226 0 -120 -48 -187 -158 -224 -43 -14 -166 -16 -1156 -16
-1248 0 -1177 -4 -1255 74 -120 120 -69 341 91 390 71 22 2245 23 2317 2z
m-3120 -960 c108 -33 161 -106 161 -226 0 -120 -48 -187 -158 -224 -63 -21
-322 -22 -391 -2 -108 33 -161 106 -161 226 0 118 52 193 157 225 61 19 330
20 392 1z m3120 0 c62 -19 111 -57 138 -109 18 -33 23 -58 22 -117 0 -120 -47
-187 -157 -224 -43 -14 -166 -16 -1156 -16 -1248 0 -1177 -4 -1256 74 -93 93
-83 273 20 351 72 55 32 54 1231 54 931 1 1118 -1 1158 -13z"/>
<path d="M4294 6706 c-49 -22 -98 -88 -126 -173 -29 -85 -48 -185 -48 -251 l0
-42 241 0 242 0 -6 75 c-8 90 -33 204 -57 261 -22 50 -73 110 -111 130 -35 17
-94 18 -135 0z"/>
<path d="M7355 3810 c-24 -10 -91 -79 -301 -310 -607 -670 -1407 -1541 -1426
-1554 -32 -23 -82 -30 -121 -17 -25 9 -101 80 -273 259 -131 136 -304 315
-385 397 -80 83 -176 182 -213 222 -37 39 -82 78 -101 87 -38 18 -92 21 -132
5 -37 -14 -280 -254 -304 -301 -22 -44 -25 -112 -5 -150 14 -26 159 -192 481
-548 136 -151 698 -776 820 -913 39 -44 82 -85 97 -93 35 -18 92 -18 127 1 16
8 149 144 297 302 147 158 298 320 334 358 36 39 97 104 136 145 38 41 101
109 140 150 39 41 171 183 294 315 123 132 253 272 290 310 36 39 192 205 345
370 154 165 304 326 335 358 147 155 149 207 11 351 -62 65 -210 189 -288 242
-37 25 -116 32 -158 14z"/>
</g>
</svg>
											</span>
                <!--end::Svg Icon-->
              </div>
              <!--end::Nav link-->
            </li>
            <!--end::Nav item-->
            <!--begin::Nav item-->
            <li class="nav-item mb-2" data-bs-toggle="tooltip" data-bs-trigger="hover" data-bs-placement="right"
                data-bs-dismiss="click" title="Clients">
              <!--begin::Nav link-->
              <div class="nav-link btn btn-custom btn-icon" data-bs-toggle="tab" @click="goToClients()">
                <!--begin::Svg Icon | path: icons/duotune/general/gen048.svg-->
                <span class="svg-icon svg-icon-2x">
											<svg  version="1.0" xmlns="http://www.w3.org/2000/svg"
                           width="860.000000pt" height="581.000000pt" viewBox="0 0 860.000000 581.000000"
                           preserveAspectRatio="xMidYMid meet">

                        <g transform="translate(0.000000,581.000000) scale(0.100000,-0.100000)"
                           fill="#EF5722" stroke="none">
                        <path d="M4050 5356 c-172 -46 -327 -122 -525 -257 -169 -115 -262 -195 -461
                        -394 -105 -105 -218 -209 -251 -232 -140 -93 -322 -141 -488 -129 -227 17
                        -426 83 -815 272 -118 57 -220 104 -227 104 -19 0 -217 -480 -483 -1170 -46
                        -118 -147 -377 -225 -575 -132 -331 -255 -670 -255 -699 0 -7 31 -17 73 -25
                        39 -7 160 -39 268 -71 301 -89 512 -130 679 -130 117 0 114 -2 149 109 67 214
                        265 462 606 762 345 303 1280 1098 1570 1335 298 243 385 304 437 304 86 0
                        251 -83 598 -301 378 -237 549 -317 701 -327 121 -7 188 27 246 125 35 60 34
                        113 -6 190 -172 341 -962 995 -1345 1112 -86 27 -139 26 -246 -3z"/>
                        <path d="M7480 5259 c-105 -48 -277 -103 -390 -125 -58 -11 -167 -18 -340 -21
                        -284 -6 -535 8 -1025 57 -367 36 -592 53 -674 48 l-65 -3 120 -99 c450 -375
                        755 -706 834 -907 34 -84 25 -161 -24 -234 -95 -137 -339 -265 -507 -265 -135
                        0 -291 46 -479 140 -140 70 -236 128 -495 299 -110 73 -226 146 -259 163 l-59
                        30 -46 -45 c-334 -320 -761 -683 -1546 -1317 -645 -520 -825 -712 -825 -880 1
                        -99 87 -206 216 -266 142 -66 221 -42 564 174 462 292 666 440 1084 791 197
                        166 363 301 368 301 32 0 -57 -139 -177 -275 -276 -313 -711 -689 -1070 -925
                        -78 -51 -112 -80 -118 -98 -5 -15 -9 -74 -10 -132 -4 -217 73 -290 302 -290
                        351 0 769 278 1469 977 138 138 252 246 252 239 0 -33 -183 -297 -314 -451
                        -348 -412 -680 -706 -947 -840 -88 -45 -88 -45 -83 -77 27 -145 140 -216 328
                        -206 162 9 339 87 512 225 116 93 433 404 734 721 100 106 185 191 187 188 9
                        -8 -97 -208 -164 -310 -152 -233 -309 -421 -591 -708 l-165 -168 7 -47 c15
                        -115 62 -195 139 -236 59 -31 176 -30 272 2 86 29 265 119 265 133 0 6 -7 47
                        -16 90 -11 55 -15 114 -12 196 4 134 16 164 92 248 54 61 120 93 267 131 57
                        14 105 27 107 29 3 2 -25 153 -48 259 -17 77 -12 200 11 262 28 72 94 144 168
                        180 51 25 66 28 171 28 63 0 147 -4 185 -8 l71 -8 12 43 c7 24 24 85 38 137
                        47 170 87 233 188 290 170 97 387 70 567 -71 20 -15 39 -28 42 -28 3 0 21 28
                        39 63 71 134 232 260 417 327 215 78 375 100 769 107 l312 5 0 44 c0 194 -305
                        1434 -474 1929 -78 227 -77 225 -89 224 -7 -1 -50 -19 -97 -40z"/>
                        <path d="M7038 2679 c-100 -55 -169 -118 -206 -189 -31 -59 -34 -71 -29 -130
                        5 -67 55 -211 76 -218 6 -2 31 6 56 18 141 68 238 240 221 388 -6 47 -47 163
                        -58 162 -2 0 -29 -14 -60 -31z"/>
                        <path d="M6233 2515 c-53 -16 -128 -63 -170 -107 -73 -76 -97 -203 -58 -318
                        62 -187 219 -412 344 -492 144 -91 401 46 435 232 12 68 -48 231 -165 446
                        -116 213 -234 287 -386 239z"/>
                        <path d="M5531 2020 c-79 -36 -140 -91 -168 -148 -22 -45 -27 -72 -31 -156 -7
                        -163 17 -225 149 -382 67 -80 166 -167 224 -197 52 -26 145 -38 206 -27 174
                        33 291 171 290 343 0 63 -3 73 -47 145 -115 190 -271 364 -372 414 -67 33
                        -189 37 -251 8z"/>
                        <path d="M5121 1283 c-14 -3 -55 -35 -91 -71 -150 -150 -167 -296 -59 -496 35
                        -65 45 -77 82 -90 256 -95 570 43 571 249 0 61 -21 105 -81 176 -134 158 -311
                        255 -422 232z"/>
                        </g>
                        </svg>
											</span>
                <!--end::Svg Icon-->
              </div>
              <!--end::Nav link-->
            </li>
            <!--end::Nav item-->
            <!--begin::Nav item-->

            <!--end::Nav item-->
            <!--begin::Nav item-->
            <li class="nav-item mb-2" data-bs-toggle="tooltip" data-bs-trigger="hover" data-bs-placement="right"
                data-bs-dismiss="click" title="Programmers">
              <!--begin::Nav link-->
              <div @click="goToProgrammers()" class="nav-link btn btn-custom btn-icon" data-bs-toggle="tab" >
                <!--begin::Svg Icon | path: icons/duotune/finance/fin006.svg-->
                <span class="svg-icon svg-icon-2x">
											<svg  version="1.0" xmlns="http://www.w3.org/2000/svg"
                           width="200.000000pt" height="200.000000pt" viewBox="0 0 200.000000 200.000000"
                           preserveAspectRatio="xMidYMid meet">

<g transform="translate(0.000000,200.000000) scale(0.100000,-0.100000)"
   fill="#EF5722" stroke="none">
<path d="M879 1947 c-98 -41 -158 -96 -203 -185 -97 -191 -15 -422 182 -515
60 -28 77 -32 157 -32 85 0 96 2 167 38 90 44 136 92 181 187 27 57 31 75 31
150 -1 155 -75 275 -212 342 -58 29 -78 33 -157 36 -76 2 -99 -1 -146 -21z
m393 -253 c34 -17 42 -45 36 -127 -10 -156 -133 -270 -290 -270 -163 0 -298
133 -298 294 0 67 3 69 73 47 91 -29 169 -21 260 28 108 56 152 62 219 28z"/>
<path d="M610 1216 c-128 -36 -230 -139 -230 -233 0 -10 134 -13 636 -13 l637
0 -6 37 c-14 83 -102 176 -195 203 -20 7 -66 14 -102 17 -60 5 -69 3 -115 -26
-129 -79 -313 -79 -436 -1 -51 34 -108 38 -189 16z"/>
<path d="M338 901 l-33 -29 0 -374 c0 -205 4 -383 8 -395 8 -22 7 -22 -115
-25 -101 -3 -123 -6 -123 -18 0 -13 111 -15 928 -18 922 -2 927 -2 927 18 0
19 -7 20 -111 20 -102 0 -110 1 -103 17 14 28 17 711 4 755 -6 20 -22 46 -37
57 -25 21 -35 21 -669 21 l-644 0 -32 -29z m767 -212 c10 -14 -124 -401 -143
-417 -13 -10 -19 -9 -31 3 -13 13 -8 35 44 187 78 230 82 238 105 238 10 0 22
-5 25 -11z m-227 -105 c2 -16 -10 -33 -43 -60 l-46 -37 45 -40 c47 -39 58 -70
31 -81 -16 -6 -132 85 -142 112 -5 11 13 33 58 74 66 60 92 68 97 32z m368
-25 c71 -62 77 -71 61 -91 -29 -36 -128 -107 -142 -102 -28 11 -15 42 31 81
l47 37 -47 42 c-43 40 -55 62 -39 77 14 14 32 5 89 -44z"/>
</g>
</svg>
											</span>
                <!--end::Svg Icon-->
              </div>
              <!--end::Nav link-->
            </li>
            <!--end::Nav item-->
          </ul>
        </div>
        <!--end::Nav-->
      </div>
      <!--end::Nav-->
      <!--begin::Footer-->
      <div class="aside-footer d-flex flex-column align-items-center flex-column-auto" id="kt_aside_footer">
        <!--begin::Chat-->
        <div class="d-flex align-items-center mb-2">
        </div>
        <!--end::Chat-->
        <!--begin::Notifications-->
        <div class="d-flex align-items-center mb-2">

          <div class="menu menu-sub menu-sub-dropdown menu-column w-350px w-lg-375px" data-kt-menu="true">
            <!--begin::Heading-->
            <div class="d-flex flex-column bgi-no-repeat rounded-top"
                 style="background-image:url('assets/media/misc/dropdown-header-bg.png')">
              <!--begin::Title-->
              <h3 class="text-white fw-bold px-9 mt-10 mb-6">Notifications
                <span class="fs-8 opacity-75 ps-3">24 reports</span></h3>
              <!--end::Title-->
              <!--begin::Tabs-->
              <ul class="nav nav-line-tabs nav-line-tabs-2x nav-stretch fw-bold px-9">
                <li class="nav-item">
                  <a class="nav-link text-white opacity-75 opacity-state-100 pb-4" data-bs-toggle="tab"
                     href="#kt_topbar_notifications_1">Alerts</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-white opacity-75 opacity-state-100 pb-4 active" data-bs-toggle="tab"
                     href="#kt_topbar_notifications_2">Updates</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-white opacity-75 opacity-state-100 pb-4" data-bs-toggle="tab"
                     href="#kt_topbar_notifications_3">Logs</a>
                </li>
              </ul>
              <!--end::Tabs-->
            </div>
            <!--end::Heading-->
            <!--begin::Tab content-->
            <div class="tab-content">
              <!--begin::Tab panel-->
              <div class="tab-pane fade" id="kt_topbar_notifications_1" role="tabpanel">
                <!--begin::Items-->
                <div class="scroll-y mh-325px my-5 px-8">
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-primary">
																<!--begin::Svg Icon | path: icons/duotune/technology/teh008.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-primary">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<path opacity="0.3"
                                          d="M11 6.5C11 9 9 11 6.5 11C4 11 2 9 2 6.5C2 4 4 2 6.5 2C9 2 11 4 11 6.5ZM17.5 2C15 2 13 4 13 6.5C13 9 15 11 17.5 11C20 11 22 9 22 6.5C22 4 20 2 17.5 2ZM6.5 13C4 13 2 15 2 17.5C2 20 4 22 6.5 22C9 22 11 20 11 17.5C11 15 9 13 6.5 13ZM17.5 13C15 13 13 15 13 17.5C13 20 15 22 17.5 22C20 22 22 20 22 17.5C22 15 20 13 17.5 13Z"
                                          fill="black"/>
																		<path
                                        d="M17.5 16C17.5 16 17.4 16 17.5 16L16.7 15.3C16.1 14.7 15.7 13.9 15.6 13.1C15.5 12.4 15.5 11.6 15.6 10.8C15.7 9.99999 16.1 9.19998 16.7 8.59998L17.4 7.90002H17.5C18.3 7.90002 19 7.20002 19 6.40002C19 5.60002 18.3 4.90002 17.5 4.90002C16.7 4.90002 16 5.60002 16 6.40002V6.5L15.3 7.20001C14.7 7.80001 13.9 8.19999 13.1 8.29999C12.4 8.39999 11.6 8.39999 10.8 8.29999C9.99999 8.19999 9.20001 7.80001 8.60001 7.20001L7.89999 6.5V6.40002C7.89999 5.60002 7.19999 4.90002 6.39999 4.90002C5.59999 4.90002 4.89999 5.60002 4.89999 6.40002C4.89999 7.20002 5.59999 7.90002 6.39999 7.90002H6.5L7.20001 8.59998C7.80001 9.19998 8.19999 9.99999 8.29999 10.8C8.39999 11.5 8.39999 12.3 8.29999 13.1C8.19999 13.9 7.80001 14.7 7.20001 15.3L6.5 16H6.39999C5.59999 16 4.89999 16.7 4.89999 17.5C4.89999 18.3 5.59999 19 6.39999 19C7.19999 19 7.89999 18.3 7.89999 17.5V17.4L8.60001 16.7C9.20001 16.1 9.99999 15.7 10.8 15.6C11.5 15.5 12.3 15.5 13.1 15.6C13.9 15.7 14.7 16.1 15.3 16.7L16 17.4V17.5C16 18.3 16.7 19 17.5 19C18.3 19 19 18.3 19 17.5C19 16.7 18.3 16 17.5 16Z"
                                        fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Project Alice</a>
                        <div class="text-gray-400 fs-7">Phase 1 development</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">1 hr</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-danger">
																<!--begin::Svg Icon | path: icons/duotune/general/gen044.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-danger">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<rect opacity="0.3" x="2" y="2" width="20" height="20" rx="10" fill="black"/>
																		<rect x="11" y="14" width="7" height="2" rx="1" transform="rotate(-90 11 14)"
                                          fill="black"/>
																		<rect x="11" y="17" width="2" height="2" rx="1" transform="rotate(-90 11 17)"
                                          fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">HR Confidential</a>
                        <div class="text-gray-400 fs-7">Confidential staff documents</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">2 hrs</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-warning">
																<!--begin::Svg Icon | path: icons/duotune/finance/fin006.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-warning">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<path opacity="0.3"
                                          d="M20 15H4C2.9 15 2 14.1 2 13V7C2 6.4 2.4 6 3 6H21C21.6 6 22 6.4 22 7V13C22 14.1 21.1 15 20 15ZM13 12H11C10.5 12 10 12.4 10 13V16C10 16.5 10.4 17 11 17H13C13.6 17 14 16.6 14 16V13C14 12.4 13.6 12 13 12Z"
                                          fill="black"/>
																		<path
                                        d="M14 6V5H10V6H8V5C8 3.9 8.9 3 10 3H14C15.1 3 16 3.9 16 5V6H14ZM20 15H14V16C14 16.6 13.5 17 13 17H11C10.5 17 10 16.6 10 16V15H4C3.6 15 3.3 14.9 3 14.7V18C3 19.1 3.9 20 5 20H19C20.1 20 21 19.1 21 18V14.7C20.7 14.9 20.4 15 20 15Z"
                                        fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Company HR</a>
                        <div class="text-gray-400 fs-7">Corporeate staff profiles</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">5 hrs</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-success">
																<!--begin::Svg Icon | path: icons/duotune/files/fil023.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-success">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<path opacity="0.3"
                                          d="M5 15C3.3 15 2 13.7 2 12C2 10.3 3.3 9 5 9H5.10001C5.00001 8.7 5 8.3 5 8C5 5.2 7.2 3 10 3C11.9 3 13.5 4 14.3 5.5C14.8 5.2 15.4 5 16 5C17.7 5 19 6.3 19 8C19 8.4 18.9 8.7 18.8 9C18.9 9 18.9 9 19 9C20.7 9 22 10.3 22 12C22 13.7 20.7 15 19 15H5ZM5 12.6H13L9.7 9.29999C9.3 8.89999 8.7 8.89999 8.3 9.29999L5 12.6Z"
                                          fill="black"/>
																		<path d="M17 17.4V12C17 11.4 16.6 11 16 11C15.4 11 15 11.4 15 12V17.4H17Z"
                                          fill="black"/>
																		<path opacity="0.3" d="M12 17.4H20L16.7 20.7C16.3 21.1 15.7 21.1 15.3 20.7L12 17.4Z"
                                          fill="black"/>
																		<path d="M8 12.6V18C8 18.6 8.4 19 9 19C9.6 19 10 18.6 10 18V12.6H8Z" fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Project Redux</a>
                        <div class="text-gray-400 fs-7">New frontend admin theme</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">2 days</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-primary">
																<!--begin::Svg Icon | path: icons/duotune/maps/map001.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-primary">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<path opacity="0.3" d="M6 22H4V3C4 2.4 4.4 2 5 2C5.6 2 6 2.4 6 3V22Z" fill="black"/>
																		<path
                                        d="M18 14H4V4H18C18.8 4 19.2 4.9 18.7 5.5L16 9L18.8 12.5C19.3 13.1 18.8 14 18 14Z"
                                        fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Project Breafing</a>
                        <div class="text-gray-400 fs-7">Product launch status update</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">21 Jan</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-info">
																<!--begin::Svg Icon | path: icons/duotune/general/gen006.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-info">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                       fill="none">
																		<path opacity="0.3"
                                          d="M22 5V19C22 19.6 21.6 20 21 20H19.5L11.9 12.4C11.5 12 10.9 12 10.5 12.4L3 20C2.5 20 2 19.5 2 19V5C2 4.4 2.4 4 3 4H21C21.6 4 22 4.4 22 5ZM7.5 7C6.7 7 6 7.7 6 8.5C6 9.3 6.7 10 7.5 10C8.3 10 9 9.3 9 8.5C9 7.7 8.3 7 7.5 7Z"
                                          fill="black"/>
																		<path
                                        d="M19.1 10C18.7 9.60001 18.1 9.60001 17.7 10L10.7 17H2V19C2 19.6 2.4 20 3 20H21C21.6 20 22 19.6 22 19V12.9L19.1 10Z"
                                        fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Banner Assets</a>
                        <div class="text-gray-400 fs-7">Collection of banner images</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">21 Jan</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center">
                      <!--begin::Symbol-->
                      <div class="symbol symbol-35px me-4">
															<span class="symbol-label bg-light-warning">
																<!--begin::Svg Icon | path: icons/duotune/art/art002.svg-->
																<span class="svg-icon svg-icon-2 svg-icon-warning">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="25" viewBox="0 0 24 25"
                                       fill="none">
																		<path opacity="0.3"
                                          d="M8.9 21L7.19999 22.6999C6.79999 23.0999 6.2 23.0999 5.8 22.6999L4.1 21H8.9ZM4 16.0999L2.3 17.8C1.9 18.2 1.9 18.7999 2.3 19.1999L4 20.9V16.0999ZM19.3 9.1999L15.8 5.6999C15.4 5.2999 14.8 5.2999 14.4 5.6999L9 11.0999V21L19.3 10.6999C19.7 10.2999 19.7 9.5999 19.3 9.1999Z"
                                          fill="black"/>
																		<path
                                        d="M21 15V20C21 20.6 20.6 21 20 21H11.8L18.8 14H20C20.6 14 21 14.4 21 15ZM10 21V4C10 3.4 9.6 3 9 3H4C3.4 3 3 3.4 3 4V21C3 21.6 3.4 22 4 22H9C9.6 22 10 21.6 10 21ZM7.5 18.5C7.5 19.1 7.1 19.5 6.5 19.5C5.9 19.5 5.5 19.1 5.5 18.5C5.5 17.9 5.9 17.5 6.5 17.5C7.1 17.5 7.5 17.9 7.5 18.5Z"
                                        fill="black"/>
																	</svg>
																</span>
                                <!--end::Svg Icon-->
															</span>
                      </div>
                      <!--end::Symbol-->
                      <!--begin::Title-->
                      <div class="mb-0 me-2">
                        <a href="#" class="fs-6 text-gray-800 text-hover-primary fw-bolder">Icon Assets</a>
                        <div class="text-gray-400 fs-7">Collection of SVG icons</div>
                      </div>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">20 March</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                </div>
                <!--end::Items-->
                <!--begin::View more-->
                <div class="py-3 text-center border-top">
                  <a href="../dist/pages/profile/activity.html" class="btn btn-color-gray-600 btn-active-color-primary">View
                    All
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr064.svg-->
                    <span class="svg-icon svg-icon-5">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                               fill="none">
														<rect opacity="0.5" x="18" y="13" width="13" height="2" rx="1"
                                  transform="rotate(-180 18 13)" fill="black"/>
														<path
                                d="M15.4343 12.5657L11.25 16.75C10.8358 17.1642 10.8358 17.8358 11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25L18.2929 12.7071C18.6834 12.3166 18.6834 11.6834 18.2929 11.2929L12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75C10.8358 6.16421 10.8358 6.83579 11.25 7.25L15.4343 11.4343C15.7467 11.7467 15.7467 12.2533 15.4343 12.5657Z"
                                fill="black"/>
													</svg>
												</span>
                    <!--end::Svg Icon--></a>
                </div>
                <!--end::View more-->
              </div>
              <!--end::Tab panel-->
              <!--begin::Tab panel-->
              <div class="tab-pane fade show active" id="kt_topbar_notifications_2" role="tabpanel">
                <!--begin::Wrapper-->
                <div class="d-flex flex-column px-9">
                  <!--begin::Section-->
                  <div class="pt-10 pb-0">
                    <!--begin::Title-->
                    <h3 class="text-dark text-center fw-bolder">Get Pro Access</h3>
                    <!--end::Title-->
                    <!--begin::Text-->
                    <div class="text-center text-gray-600 fw-bold pt-1">Outlines keep you honest. They stoping you from
                      amazing poorly about drive
                    </div>
                    <!--end::Text-->
                    <!--begin::Action-->
                    <div class="text-center mt-5 mb-9">
                      <a href="#" class="btn btn-sm btn-primary px-6" data-bs-toggle="modal"
                         data-bs-target="#kt_modal_upgrade_plan">Upgrade</a>
                    </div>
                    <!--end::Action-->
                  </div>
                  <!--end::Section-->
                  <!--begin::Illustration-->
                  <div class="text-center px-4">
                    <img class="mw-100 mh-200px" alt="metronic" src="/assets/media/illustrations/sigma-1/6.png"/>
                  </div>
                  <!--end::Illustration-->
                </div>
                <!--end::Wrapper-->
              </div>
              <!--end::Tab panel-->
              <!--begin::Tab panel-->
              <div class="tab-pane fade" id="kt_topbar_notifications_3" role="tabpanel">
                <!--begin::Items-->
                <div class="scroll-y mh-325px my-5 px-8">
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-success me-4">200 OK</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">New order</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Just now</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-danger me-4">500 ERR</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">New customer</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">2 hrs</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-success me-4">200 OK</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Payment process</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">5 hrs</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-warning me-4">300 WRN</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Search query</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">2 days</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-success me-4">200 OK</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">API connection</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">1 week</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-success me-4">200 OK</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Database restore</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Mar 5</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-warning me-4">300 WRN</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">System update</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">May 15</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-warning me-4">300 WRN</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Server OS update</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Apr 3</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-warning me-4">300 WRN</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">API rollback</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Jun 30</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-danger me-4">500 ERR</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Refund process</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Jul 10</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-danger me-4">500 ERR</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Withdrawal process</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Sep 10</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                  <!--begin::Item-->
                  <div class="d-flex flex-stack py-4">
                    <!--begin::Section-->
                    <div class="d-flex align-items-center me-2">
                      <!--begin::Code-->
                      <span class="w-70px badge badge-light-danger me-4">500 ERR</span>
                      <!--end::Code-->
                      <!--begin::Title-->
                      <a href="#" class="text-gray-800 text-hover-primary fw-bold">Mail tasks</a>
                      <!--end::Title-->
                    </div>
                    <!--end::Section-->
                    <!--begin::Label-->
                    <span class="badge badge-light fs-8">Dec 10</span>
                    <!--end::Label-->
                  </div>
                  <!--end::Item-->
                </div>
                <!--end::Items-->
                <!--begin::View more-->
                <div class="py-3 text-center border-top">
                  <a href="../dist/pages/profile/activity.html" class="btn btn-color-gray-600 btn-active-color-primary">View
                    All
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr064.svg-->
                    <span class="svg-icon svg-icon-5">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                               fill="none">
														<rect opacity="0.5" x="18" y="13" width="13" height="2" rx="1"
                                  transform="rotate(-180 18 13)" fill="black"/>
														<path
                                d="M15.4343 12.5657L11.25 16.75C10.8358 17.1642 10.8358 17.8358 11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25L18.2929 12.7071C18.6834 12.3166 18.6834 11.6834 18.2929 11.2929L12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75C10.8358 6.16421 10.8358 6.83579 11.25 7.25L15.4343 11.4343C15.7467 11.7467 15.7467 12.2533 15.4343 12.5657Z"
                                fill="black"/>
													</svg>
												</span>
                    <!--end::Svg Icon--></a>
                </div>
                <!--end::View more-->
              </div>
              <!--end::Tab panel-->
            </div>
            <!--end::Tab content-->
          </div>
          <!--end::Menu-->
          <!--end::Menu wrapper-->
        </div>
        <!--end::Notifications-->
        <!--begin::Activities-->
        <!--end::Activities-->
        <!--begin::User-->
        <div class="d-flex align-items-center mb-10" id="kt_header_user_menu_toggle">
          <!--begin::Menu wrapper-->
          <div class="cursor-pointer symbol symbol-40px" data-kt-menu-trigger="click" data-kt-menu-overflow="true"
               data-kt-menu-placement="top-start" data-bs-toggle="tooltip" data-bs-placement="right"
               data-bs-dismiss="click" title="User profile">
            <span class="symbol-label bg-primary text-inverse-primary fw-bold">{{ user.firstName[0] }}</span>
          </div>
          <!--begin::Menu-->
          <div
              id="user_menu" class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg menu-state-primary fw-bold py-4 fs-6 w-275px"
              data-kt-menu="true">
            <!--begin::Menu item-->
            <div class="menu-item px-3">
              <div class="menu-content d-flex align-items-center px-3">
                <!--begin::Avatar-->
                <div class="symbol symbol-50px me-5">
                  <span class="symbol-label bg-primary text-inverse-primary fw-bold">{{ user.firstName[0] }}</span>
                </div>
                <!--end::Avatar-->
                <!--begin::Username-->
                <div class="d-flex flex-column">
                  <div class="fw-bolder d-flex align-items-center fs-5">{{ user.firstName }} {{ user.lastName }}
                   </div>
                  <a href="#" class="fw-bold text-muted text-hover-primary fs-7">{{ user.email }}</a>
                </div>
                <!--end::Username-->
              </div>
            </div>
            <!--end::Menu item-->
            <!--begin::Menu separator-->
            <div class="separator my-2"></div>
            <!--end::Menu separator-->
            <!--begin::Menu item-->
            <div class="menu-item px-5">
              <div @click="goToProfile" class="menu-link px-5">My Profile</div>
            </div>
            <!--end::Menu item-->
            <!--begin::Menu separator-->
            <div class="separator my-2"></div>
            <!--end::Menu separator-->
            <!--begin::Menu item-->
<!--            <div class="menu-item px-5" data-kt-menu-trigger="hover" data-kt-menu-placement="right-end">-->
<!--              <a href="#" class="menu-link px-5">-->
<!--											<span class="menu-title position-relative">Language-->
<!--											<span class="fs-8 rounded bg-light px-3 py-2 position-absolute translate-middle-y top-50 end-0">English-->
<!--											<img class="w-15px h-15px rounded-1 ms-2" src="/assets/media/flags/united-states.svg"-->
<!--                           alt=""/></span></span>-->
<!--              </a>-->
<!--              &lt;!&ndash;begin::Menu sub&ndash;&gt;-->
<!--              <div class="menu-sub menu-sub-dropdown w-175px py-4">-->
<!--                &lt;!&ndash;begin::Menu item&ndash;&gt;-->
<!--                <div class="menu-item px-3">-->
<!--                  <a href="#" class="menu-link d-flex px-5 active">-->
<!--												<span class="symbol symbol-20px me-4">-->
<!--													<img class="rounded-1" src="/assets/media/flags/united-states.svg" alt=""/>-->
<!--												</span>English</a>-->
<!--                </div>-->
<!--                &lt;!&ndash;end::Menu item&ndash;&gt;-->
<!--              </div>-->
<!--              &lt;!&ndash;end::Menu sub&ndash;&gt;-->
<!--            </div>-->
            <!--end::Menu item-->
            <!--begin::Menu item-->
            <div class="menu-item px-5">
              <div @click="singOut" class="menu-link px-5">Sign Out</div>
            </div>
            <!--end::Menu item-->
            <!--begin::Menu separator-->
<!--            <div class="separator my-2"></div>-->
            <!--end::Menu separator-->
            <!--begin::Menu item-->
<!--            <div class="menu-item px-5">-->
<!--              <div class="menu-content px-5">-->
<!--                <label class="form-check form-switch form-check-custom form-check-solid pulse pulse-success"-->
<!--                       for="kt_user_menu_dark_mode_toggle">-->
<!--                  <input class="form-check-input w-30px h-20px" type="checkbox" value="1" name="mode"-->
<!--                         id="kt_user_menu_dark_mode_toggle" data-kt-url="../dist/index.html"/>-->
<!--                  <span class="pulse-ring ms-n1"></span>-->
<!--                  <span class="form-check-label text-gray-600 fs-7">Dark Mode</span>-->
<!--                </label>-->
<!--              </div>-->
<!--            </div>-->
            <!--end::Menu item-->
          </div>
          <!--end::Menu-->
          <!--end::Menu wrapper-->
        </div>
        <!--end::User-->
      </div>
      <!--end::Footer-->
    </div>
    <!--end::Primary-->
    <!--begin::Aside Toggle-->
    <button
        class="btn btn-sm btn-icon bg-body btn-color-gray-600 btn-active-primary position-absolute translate-middle start-100 end-0 bottom-0 shadow-sm d-none d-lg-flex"
        data-kt-toggle="true" data-kt-toggle-state="active" data-kt-toggle-target="body"
        data-kt-toggle-name="aside-minimize" style="margin-bottom: 1.35rem" id="hideButtonMin">
      <!--begin::Svg Icon | path: icons/duotune/arrows/arr063.svg-->
      <span class="svg-icon svg-icon-2 rotate-180">
							<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
								<rect opacity="0.5" x="6" y="11" width="13" height="2" rx="1" fill="black"/>
								<path
                    d="M8.56569 11.4343L12.75 7.25C13.1642 6.83579 13.1642 6.16421 12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75L5.70711 11.2929C5.31658 11.6834 5.31658 12.3166 5.70711 12.7071L11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25C13.1642 17.8358 13.1642 17.1642 12.75 16.75L8.56569 12.5657C8.25327 12.2533 8.25327 11.7467 8.56569 11.4343Z"
                    fill="black"/>
							</svg>
						</span>
      <!--end::Svg Icon-->
    </button>
    <!--end::Aside Toggle-->
  </div>

</template>

<script>
export default {
  name: "AsideMenu",
  data(){
    return{
      user: JSON.parse(sessionStorage.user),
    }
  },
  methods: {
    singOut(){
      sessionStorage.clear()
      this.$router.push("/");
    },

    goToProjects() {
      this.$router.push("/projects");
    },

    goToProgrammers() {
      this.$router.push("/programmers");
    },

    goToProfile() {
      this.$router.push("/programmers/view");
    },

    goToClients() {
      this.$router.push("/clients");
    },

    goToHome() {
      this.$router.push("/home");
    }
  }

}

</script>


<style scoped>
#hideButtonMin {
  visibility: hidden;
}

  #kt_header_user_menu_toggle:hover #user_menu{
    display: block;
    bottom: 30px;
    position: absolute;
    left: 30px;
  }
</style>