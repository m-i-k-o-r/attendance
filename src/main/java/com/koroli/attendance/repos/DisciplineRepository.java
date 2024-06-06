package com.koroli.attendance.repos;

import com.koroli.attendance.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, UUID> {
    @Query("""

            SELECT d 
            FROM Discipline d 
            WHERE d.professor.id = :professorId 
            AND EXISTS (
                SELECT 1 
                FROM Schedule s 
                WHERE s.discipline.id = d.id 
                AND s.weekday = :weekday 
                AND :timeNow BETWEEN s.timeStart AND s.timeEnd
            )""")
    List<Discipline> findByTime(@Param("professorId") UUID professorId,
                                @Param("weekday") String weekday,
                                @Param("timeNow") Time timeNow);

}
