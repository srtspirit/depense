package ca.vastier.depense.daos;

import ca.vastier.depense.web.dto.ArticleDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleDao extends CrudRepository<ArticleDto, Long>
{
}
