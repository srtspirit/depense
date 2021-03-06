package ca.vastier.depense.persistence.daos;

import ca.vastier.depense.web.dto.ArticleDto;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleDao extends GenericDao<ArticleDto>
{
}
