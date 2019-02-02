package ca.vastier.depense.services.impl;

import ca.vastier.depense.services.ArticleService;
import ca.vastier.depense.web.dto.ArticleDto;
import org.springframework.stereotype.Component;


@Component
public class DefaultArticleServiceImpl extends AbstractGenericEntityService<ArticleDto> implements ArticleService
{
}
