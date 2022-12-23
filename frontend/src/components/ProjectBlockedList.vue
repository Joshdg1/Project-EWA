<template>
    <div>
        <div class="row g-5 g-xl-10 mb-5 mb-xl-10" >
            <div v-for="project in projects" v-bind:key="project" class="col-lg-6">
                <!--begin::Card widget 18-->
                <div class="card card-flush h-md-100">
                    <!--begin::Body-->
                    <div class="card-body">
                        <!--begin::Row-->
                        <div class="d-flex flex-column h-100">
                            <!--begin::Header-->
                            <div class="mb-7">
                                <!--begin::Headin-->
                                <div class="d-flex flex-stack mb-6">
                                    <!--begin::Title-->
                                    <div class="flex-shrink-0 me-5">
                                        <span class="text-gray-400 fs-7 fw-bold me-2 d-block lh-1 pb-1">#{{ project.id }}</span>
                                        <span class="text-gray-800 fs-1 fw-bold">{{ project.title }}</span>
                                    </div>
                                    <!--end::Title-->
                                    <span class="badge badge-light-success flex-shrink-0 align-self-center py-3 px-4 fs-7">In Behandeling</span>
                                </div>
                                <!--end::Heading-->
                                <!--begin::Items-->
                                <div class="d-flex align-items-center flex-wrap d-grid gap-2">
                                    <!--begin::Item-->
                                    <div class="d-flex align-items-center me-5 me-xl-13">
                                        <!--begin::Symbol-->
                                        <div class="symbol symbol-30px symbol-circle me-3">
                                            <span class="symbol-label bg-primary text-inverse-primary fw-bold">C</span>
                                        </div>
                                        <!--end::Symbol-->
                                        <!--begin::Info-->
                                        <div class="m-0">
                                            <span class="fw-semibold text-gray-400 d-block fs-8">Bedrijf</span>
                                            <a href="/seven-html-pro/?page=pages/user-profile/overview"
                                               class="fw-bold text-gray-800 text-hover-primary fs-7">{{ project.company }}</a>
                                        </div>
                                        <!--end::Info-->
                                    </div>
                                </div>
                                <!--end::Items-->
                            </div>
                            <!--end::Header-->
                            <!--begin::Body-->
                            <div class="mb-6">
                                <!--begin::Text-->
                                <span class="fw-semibold text-gray-600 fs-6 mb-8 d-block">{{ project.description }}</span>
                                <!--end::Text-->
                                <!--begin::Stats-->
                                <div class="d-flex">
                                    <!--begin::Stat-->
                                    <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 me-6 mb-3">
                                        <!--begin::Date-->
                                        <span class="fs-6 text-gray-700 fw-bold">Feb 6, 2021</span>
                                        <!--end::Date-->
                                        <!--begin::Label-->
                                        <div class="fw-semibold text-gray-400">Start datum</div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Stat-->
                                    <!--begin::Stat-->
                                    <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 mb-3">
                                        <!--begin::Number-->
                                        <span class="fs-6 text-gray-700 fw-bold">420</span>
                                        <!--end::Number-->
                                        <!--begin::Label-->
                                        <div class="fw-semibold text-gray-400">Gewerkte uren</div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Stat-->
                                </div>
                                <!--end::Stats-->
                            </div>
                            <!--end::Body-->
                            <!--begin::Footer-->
                          <span class="fw-semibold text-gray-400 d-block fs-8 mb-2">Toegewezen specialist(en)</span>
                            <div class="d-flex flex-stack mt-auto bd-highlight">
                                <!--begin::Users group-->
                                <div class="symbol-group symbol-hover flex-nowrap">
                                    <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                         data-bs-original-title="Susan Redwood" data-kt-initialized="1">
                                        <span class="symbol-label bg-primary text-inverse-primary fw-bold">R</span>
                                    </div>
                                    <div class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                                         data-bs-original-title="Susan Redwood" data-kt-initialized="1">
                                        <span class="symbol-label bg-primary text-inverse-primary fw-bold">S</span>
                                    </div>
                                </div>
                                <!--end::Users group-->
                                <!--begin::Actions-->
                                <a href="/seven-html-pro/?page=apps/projects/project"
                                   class="text-dark opacity-75-hover fs-6 fw-semibold">Meer details
                                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr095.svg-->
                                    <span class="svg-icon svg-icon-4 svg-icon-primary ms-1">
																<svg width="24" height="24" viewBox="0 0 24 24"
                                                                     fill="none" xmlns="http://www.w3.org/2000/svg">
																	<path opacity="0.3"
                                                                          d="M4.7 17.3V7.7C4.7 6.59543 5.59543 5.7 6.7 5.7H9.8C10.2694 5.7 10.65 5.31944 10.65 4.85C10.65 4.38056 10.2694 4 9.8 4H5C3.89543 4 3 4.89543 3 6V19C3 20.1046 3.89543 21 5 21H18C19.1046 21 20 20.1046 20 19V14.2C20 13.7306 19.6194 13.35 19.15 13.35C18.6806 13.35 18.3 13.7306 18.3 14.2V17.3C18.3 18.4046 17.4046 19.3 16.3 19.3H6.7C5.59543 19.3 4.7 18.4046 4.7 17.3Z"
                                                                          fill="currentColor"></path>
																	<rect x="21.9497" y="3.46448" width="13" height="2"
                                                                          rx="1" transform="rotate(135 21.9497 3.46448)"
                                                                          fill="currentColor"></rect>
																	<path d="M19.8284 4.97161L19.8284 9.93937C19.8284 10.5252 20.3033 11 20.8891 11C21.4749 11 21.9497 10.5252 21.9497 9.93937L21.9497 3.05029C21.9497 2.498 21.502 2.05028 20.9497 2.05028L14.0607 2.05027C13.4749 2.05027 13 2.52514 13 3.11094C13 3.69673 13.4749 4.17161 14.0607 4.17161L19.0284 4.17161C19.4702 4.17161 19.8284 4.52978 19.8284 4.97161Z"
                                                                          fill="currentColor"></path>
																</svg>
															</span>
                                    <!--end::Svg Icon--></a>
                                <!--end::Actions-->
                            </div>
                            <!--end::Footer-->
                        </div>
                        <!--end::Wrapper-->

                        <!--end::Row-->
                    </div>
                    <!--end::Body-->
                </div>
                <!--end::Card widget 18-->
            </div>
        </div>
    </div>
</template>

<script>
    import ProjectRepository from '../repository/ProjectRepository.js'

    export default {

        name: "ProjectAdmin.vue",
        props: ['projects'],
        emits: ['deleteProject', 'editProject'],

        data() {
            return {
                editingProject: null,
                repository: new ProjectRepository(),
            }
        },

        methods: {

            async deleteProject(project) {
                await this.repository.deleteProjectById(project.id);
                location.reload();
            },

            editProject() {
                this.editingProject = true;
                this.$emit('editProject', this.editingProject)
            }
        }
    }
</script>

<style scoped>

</style>