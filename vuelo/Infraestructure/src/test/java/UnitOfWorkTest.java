import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.Mediator;
import core.DomainEvent;

public class UnitOfWorkTest {

	private IWriteDbContext _context = Mockito.mock(IWriteDbContext.class);
	private Mediator _mediator = Mockito.mock(Mediator.class);

	@Test
	public void constructorVoid_accept() {
		UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
		Assert.assertNotNull(unitOfWork);
	}

	@Test
	public void commit_accept() throws Exception {
		UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
		List<Object> list = new ArrayList<Object>();
		list.add(new DomainEvent() {
		});
		when(_context.getDomainEvents()).thenReturn(list);
		try {
			unitOfWork.commit();
		} catch (HttpException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void commit_denied() throws Exception {
		UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
		try {
			unitOfWork.commit();
		} catch (HttpException e) {
			e.printStackTrace();
		}
	}
}
