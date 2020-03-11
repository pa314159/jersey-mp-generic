package ascelion.rest.api;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ViewResourceBase<V> implements ViewResource<V> {
	final Class<V> type;

	@Override
	public V getGeneric(UUID id) {
		return findById(id);
	}

	protected abstract V findById(UUID id);
}
