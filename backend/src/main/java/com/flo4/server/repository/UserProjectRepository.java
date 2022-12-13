//package com.flo4.server.repository;
//
//import com.flo4.server.models.Project;
//import com.flo4.server.models.UserProject;
//import org.hibernate.Hibernate;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//@Repository("USERPROJECT.JPA")
//@Transactional
//public class UserProjectRepository {
//    @PersistenceContext
//    protected EntityManager entityManager;
//
//    public List<UserProject> findAll() {
//        TypedQuery<UserProject> query = this.entityManager.createQuery("select p from User_Project p", UserProject.class);
//        List<UserProject> projects = query.getResultList();
//
//        for (UserProject project : projects) {
//            Hibernate.initialize(project.getUser());
//        }
//
//        return projects;
//    }
//
//    @Override
//    public UserProject findById(int id) {
//        return this.entityManager.find(UserProject.class, id);
//    }
//
//    @Override
//    public Project save(UserProject project) {
//        return this.entityManager.merge(project);
//    }
//
//    @Override
//    public Project update(UserProject project, int id) {
//        Project updatedProject = findById(id);
//
//        if (updatedProject == null) {
//            return null;
//        }
//
//        updatedProject.setTitle(project.getTitle());
//        updatedProject.setDescription(project.getDescription());
//        updatedProject.setCompany(project.getCompany());
//        updatedProject.setUsers(project.getUsers());
//        updatedProject.setStartDate(project.getStartDate());
//        updatedProject.setEndDate(project.getEndDate());
////        updatedProject.setUsers(project.getUsers());
////        updatedProject.setHoursWorked(project.getHoursWorked());
//
//        return updatedProject;
//    }
//
//    @Override
//    public Project deleteById(int id) {
//        Project project = this.findById(id);
//        this.entityManager.remove(project);
//        return project;
//    }
//
//    @Override
//    public List<Project> findByQuery(String jpqlName, Object... params) {
//        TypedQuery<Project> query = this.entityManager.createNamedQuery(jpqlName, Project.class);
//
//        //Put all params into the query.
//        for (int i = 0; i < params.length; i++) {
//            query.setParameter(i + 1, params[i]);
//        }
//
//        //Execute the query and return all the results.
//        return query.getResultList();
//    }
//}
