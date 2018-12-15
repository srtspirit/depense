package ca.vastier.depense.web.wsdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleWsDto
{
	private long id;
	private String name;
}
