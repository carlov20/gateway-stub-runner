package contracts.consumer;

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method "GET"
		url '/user'
		headers {
			accept('application/json')
		}
	}
	response {
		status OK()
		body([
			username: $(anyNonEmptyString()),
			age: 10
			])
		headers {
			contentType('application/json')
		}
	}
	
}
