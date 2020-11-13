package ca.vastier.depense.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;

import ca.vastier.depense.web.aop.Secured;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthorisingInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception
	{
		final Secured secured = ((HandlerMethod) handler).getMethod().getAnnotation(Secured.class);
		if (secured != null)
		{
			final String jwt = request.getHeader("Authorization");
			final Jwt<Header, Claims> token;
			try
			{
				token = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parse(jwt);
			}
			catch (final JwtException e)
			{
				response.sendError(403, e.getMessage());
				return false;
			}

			final String role = token.getBody().get("role", String.class);

			if(Arrays.stream(secured.allowedRoles()).noneMatch(role::equals))
			{
				response.sendError(403, role + " has no access");
				return false;
			}
		}
		return true;
	}
}
