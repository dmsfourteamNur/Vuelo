import java.util.List;

import Context.IWriteDbContext;
import Fourteam.db.Exception.DataBaseException;
import Fourteam.mediator.Mediator;
import Repositories.IUnitOfWork;
import core.ConfirmedDomainEvent;
import core.DomainEvent;

public class UnitOfWork implements IUnitOfWork {

	private IWriteDbContext _context;
	private Mediator _mediator;

	public UnitOfWork(IWriteDbContext context, Mediator mediator) {
		_context = context;
		_mediator = mediator;
	}

	@Override
	public void commit() throws Exception {
		List<Object> events = _context.getDomainEvents();
		for (Object domainEvent : events) {
			try {
				DomainEvent event = (DomainEvent) domainEvent;
				_mediator.notify(event);
			} catch (Exception e) {
			}
		}
		try {
			_context.Commit();
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		for (Object domainEvent : events) {
			try {
				DomainEvent event = (DomainEvent) domainEvent;
				_mediator.notify(MakeGeneryc(event));
			} catch (Exception e) {
			}
		}
	}

	public <T> ConfirmedDomainEvent<T> MakeGeneryc(T o) {
		return new ConfirmedDomainEvent<T>(o);
	}
}