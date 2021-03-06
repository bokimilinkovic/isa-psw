import Vue from "vue";
import Router from "vue-router";


Vue.use(Router);

const router = new Router({
    mode: "hash",
    routes: [{
            path: "/",
            name: "Home",
            component: () =>
                import ("./components/Home")
        },
        {
            path: "/profile",
            name: "Profile",
            component: () =>
                import ("./components/CCAProfileComp/CCAProfile")
        },
        {
            path: "/login",
            name: "Login",
            component: () =>
                import ("./components/Login")
        },
        {
            path: "/fastExams",
            name: "FastExams",
            component: () => 
                import("./components/FastExaminations")
            
        },
        {
            path: "/medicalFile",
            name: "MedicalFile",
            props:true,
            component: () =>
                import ("./components/MedicalFile")
        },
        {
            path: "/register",
            name: "Register",
            component: () =>
                import ("./components/Register")
        },
        {
            path: "/caProfile",
            name: "CAProfile",
            component: () =>
                import ("./components/CAProfileComp/CAProfile")
        },
        {
            path: "/caDoctors",
            name: "CADoctors",
            component: () =>
                import ("./components/CAProfileComp/Doctors")
        },
        {
            path: "/patientProfile",
            name: "PatientProfile",
            component: () =>
                import ("./components/PatientProfile")
        },
        {
            path: '/patientProfile/:id',
            props: true,
            component: () =>
                import ("./components/PatientProfile")
        },
        {
            path: "/userProfile/:id",
            name: "UserProfile",
            props: true,
            component: () =>
                import ("./components/UserProfile")

        },
        {
            path: "/userProfile",
            name: "UserProfile",
            component: () =>
                import ("./components/UserProfile")
        },
        {
            path: "/clinicProfile",
            name: "ClinicProfile",

            component: () =>
                import ("./components/CAProfileComp/ClinicProfile")
        },
        {
            path: "/priceList",
            name: "Pricelist",

            component: () =>
                import ("./components/CAProfileComp/Pricelist")
        },

        {
            path: "/changeClinicData",
            name: "ChangeClinicData",

            component: () =>
                import ("./components/CAProfileComp/ChangeClinicData")
        },

        {
            path: "/examinTypes",
            name: "ExaminTypes",

            component: () =>
                import ("./components/CAProfileComp/ExaminTypes")
        },
        {
            path: "/operationTypes",
            name: "OperationTypes",

            component: () =>
                import ("./components/CAProfileComp/OperationTypes")
        },
        {
            path: "/changeData",
            name: "ChangeData",
            component: () =>
                import ("./components/ChangeData")


        },
        {
            path: "/passwordChange",
            name: "PasswordChange",
            component: () =>
                import ("./components/PasswordChange")


        },
        {
            path: "/search",
            name: "Search",
            component: () =>
                import ("./components/Search")
        },
        {
            path: "/examination/:id",
            props: true,
            name: "Examination",
            component: () =>
                import ("./components/Examination")
        },
        {
            path: "/operation/:id",
            props: true,
            name: "Operation",
            component: () =>
                import ("./components/Operation")
        },
        {
            path: '/holiday',
            props: true,
            name: "Holiday",
            component: () =>
                import ("./components/Holiday")
        },
        {
            path: "/requestsTable",
            name: "StaffRequests",
            component: () =>
                import ("./components/CAProfileComp/StaffRequests")
        },
        {
            path: "/examRequests",
            name: "ExamRequests",
            props: true,
            component: () =>
                import ("./components/CAProfileComp/ExamRequests")
        },
        {
            path: '/prescriptions',
            props: true,
            name: "Prescriptions",
            component: () =>
                import ("./components/PrescriptionVerification")
        },
        {
            path: "/rooms",
            name: "Rooms",
            props: true,
            component: () =>
                import ("./components/CAProfileComp/Rooms")
        },
        {
            path: "/calendarRoom",
            name: "CalendarRoom",
            props: true,
            component: () =>
                import ("./components/CAProfileComp/CalendarRoom")
        },
        {
            path: "/calendarRoomOperation",
            name: "CalendarRoomOperation",
            props: true,
            component: () =>
                import ("./components/CAProfileComp/CalendarRoomOperation")
        },
        {
            path: "/calendarDoctor",
            name: "CalendarDoctor",
            component: () =>
                import ("./components/CalendarDoctor")
        },
        {
            path: "/fastExamination",
            name: "FastExamination",
            component: () =>
                import ("./components/CAProfileComp/FastExamination")
        },
        {
            path: "/businessReport",
            name: "BusinessReport",
            props: true,
            component: () =>
                import ("./components/CAProfileComp/BusinessReport")
        },
    ]
});

export default router;