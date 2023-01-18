package com.flo4.server.repository;

import com.flo4.server.models.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository("PROJECT.JPA")
@Transactional
public class ProjectRepository implements EntityRepository<Project> {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * @return All projects from the database.
     */
    public List<Project> findAll() {
        TypedQuery<Project> query = this.entityManager.createQuery("select p from Project p", Project.class);
        List<Project> projects = query.getResultList();

        return projects;
    }

    /**
     * @param id
     * @return The project found by the given id.
     */
    @Override
    public Project findById(int id) {
        return this.entityManager.find(Project.class, id);
    }

    /**
     * @param project
     * @return The project saved in the database.
     */
    @Override
    public Project save(Project project) {
        return this.entityManager.merge(project);
    }

    /**
     * @param project
     * @param id
     * @return The project updated in the database.
     */
    @Override
    public Project update(Project project, int id) {
        Project updatedProject = findById(id);

        if (updatedProject == null) {
            return null;
        }

        updatedProject.setTitle(project.getTitle());
        updatedProject.setDescription(project.getDescription());
        updatedProject.setStartDate(project.getStartDate());
        updatedProject.setEndDate(project.getEndDate());
        updatedProject.setUsers(project.getUsers());

        return updatedProject;
    }

    /**
     * @param id
     * @return Deleted the project in the database.
     */
    @Override
    public Project deleteById(int id) {
        Project project = this.findById(id);
        this.entityManager.remove(project);
        return project;
    }

    /**
     * @param jpqlName
     * @param params
     * @return All results from the database from the given query with parameters.
     */
    @Override
    public List<Project> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Project> query = this.entityManager.createNamedQuery(jpqlName, Project.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
