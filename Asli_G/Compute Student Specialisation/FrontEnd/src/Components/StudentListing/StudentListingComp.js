import '../StudentListing/style1.css'
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from '../../Auth/api';
import { useAuth } from '../../Auth/AuthContext';
function App() {

	const navigate = useNavigate();
	const { isAuthenticated } = useAuth();
	const { setAuthenticated } = useAuth();

	console.log(localStorage.getItem('isLogin'))

	
	const handleSubmit = (e) => {


		//setAuthenticated(false)
		localStorage.removeItem('token');
		localStorage.setItem('isLogin', 'false');
		navigate('/')


	};

	const [data, setProducts] = useState([]);
	const [loading, setLoading] = useState(false);
	useEffect(()=>{
		// if (!isAuthenticated ) {
		// 	return navigate('/');
		// }
		if(localStorage.getItem('isLogin') != 'true')
		{
			return navigate('/');
		}
		
		
	})

	

	useEffect(() => {
		
		
			const fetchProducts = async () => {
				try {
					const response = await axios.get('/student/Specialization');
					setProducts(response.data);
					setLoading(false);
				} catch (error) {
					console.error('Error fetching product data:', error);
					setLoading(false);
				}
			};


			fetchProducts();

		


	}, []);


	const [deptFilter, setCategoryFilter] = useState('');
	const [spFilter, setPriceFilter] = useState('');

	const handleCategoryChange = (e) => {
		setCategoryFilter(e.target.value);
	};

	const handlePriceChange = (e) => {
		setPriceFilter(e.target.value);
	};

	const filterDomainSpeciliastion = data.filter((data) => {
		const domainMatch = !deptFilter || data.dept === deptFilter;
		const spMatch = !spFilter || data.specialisation === spFilter;

		return domainMatch && spMatch;
	});
	return (
		<div>
		

			<div>

				<section class="ftco-section">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-md-6 text-center mb-5" style={{ marginLeft: '4cm' }} >
								<h2 class="heading-section" style={{ fontWeight: 'lighter', textAlign: 'center', marginLeft: '1.5cm' }}>Student Specialization</h2>

							</div>

						</div>
						<hr style={{ borderTop: '1px solid red' }}></hr>
						<div class="row">
							<div class="col-md-12">
								<div class="table-wrap">
									<table class="table">
										<thead class="thead-dark">
											<tr>
												<th>Roll Number</th>
												<th>Name</th>
												<th>Department<label>

													<select style={{ background: 'none', border: 'none' }} value={deptFilter} onChange={handleCategoryChange}>
														<option value="">All</option>
														<option value="CS">CS</option>
														<option value="ECE">ECE</option>

													</select>
												</label></th>
												<th>Specialisation <label>

													<select style={{ background: 'none', border: 'none' }} value={spFilter} onChange={handlePriceChange} >
														<option value="">All</option>
														<option value="AI">AI</option>
														<option value="ML">ML</option>
														<option value="VLSI">VLSI</option>
													</select>
												</label></th>
												<th>&nbsp;</th>
												<th>Credit</th>
											</tr>
										</thead>

										<tbody>
											{filterDomainSpeciliastion.map((data, index) => (
												<tr class="alert" role="alert">

													<td>{data.roll_number}</td>
													<td>{data.first_name} {data.last_name}</td>
													<td>{data.dept}</td>
													<td>{data.specialisation}</td>
													<td>{data.credit}</td>

													<td>
														<a href="#" class="close" data-dismiss="alert" aria-label="Close">
															<span aria-hidden="true"><i class="fa fa-close"></i></span>
														</a>
													</td>
												</tr>))}

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<button style={{marginLeft:'80%'}} onClick={handleSubmit} >Logout</button>
					</div>
					
				</section>
				
			</div>
			
			
		</div>

	);
}

export default App;