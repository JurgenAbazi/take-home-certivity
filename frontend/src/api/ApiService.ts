import axios from 'axios'
import {useQuery} from 'react-query'
import {HtmlElementComponent} from "../pages/components/html-element-component.ts";

const apiClient = axios.create({
    baseURL: `${import.meta.env.VITE_API_HOST}`,
    headers: {
        'Content-type': 'application/json',
        Accept: 'application/json',
    },
})

const useGetHTMLElements = () => {
    return useQuery<HtmlElementComponent[], Error>(['controller'], async () => {
        const response = await apiClient.get<HtmlElementComponent[]>('/html/')
        console.log(response)
        return response.data
    })
}

const ApiService = {
    useGetHTMLElements,
}
export default ApiService
