import ApiService from '../api/ApiService'
import {HtmlElementComponent} from "./components/html-element-component.ts";
import React from "react";

function Home() {
    const {data: htmlElements} = ApiService.useGetHTMLElements()

    return (
        <div className="flex flex-col gap-3">
            {htmlElements?.map((elementComponent: HtmlElementComponent, index: number) => (
                <div key={index} className="border-1 rounded-lg shadow-md p-3">
                    <p className="mb-0"><span className="font-bold">Text:</span> {elementComponent.text}</p>
                    <p className="mb-0"><span className="font-bold">Html:</span> {elementComponent.html}</p>
                    <p className="mb-0"><span className="font-bold">Length:</span> {elementComponent.length}</p>
                    <p className="mb-0"><span className="font-bold">Sort:</span> {elementComponent.sort}</p>
                    <p className="mb-0"><span className="font-bold">Created At:</span> {elementComponent.createdAt}</p>
                    <p className="mb-0"><span
                        className="font-bold">Last Modified:</span> {elementComponent.lastModified}</p>

                    {/*<div className="border-b-1 w-full my-2"></div>*/}

                    {/*<div className="flex justify-between items-center gap-3 mb-2">*/}
                    {/*    <span className="font-bold">Comments</span>*/}
                    {/*    <button className="px-3 py-1 bg-blue-500 text-white rounded" type="button">+ Add Comment*/}
                    {/*    </button>*/}
                    {/*</div>*/}

                    {/*<div className="flex flex-col gap-2">*/}
                    {/*    {comments.map((comment, i) => (*/}
                    {/*        <div key={i} className="border-1 rounded-lg shadow-md flex justify-between items-center gap-3 p-2">*/}
                    {/*            <div>*/}
                    {/*                {comment.comment} - <span className="italic">{comment.date}</span>*/}
                    {/*            </div>*/}

                    {/*            <div className="flex gap-2">*/}
                    {/*                <button className="px-3 py-1 bg-blue-500 text-white rounded" type="button">Edit</button>*/}
                    {/*                <button className="px-3 py-1 bg-red-500 text-white rounded" type="button">Delete</button>*/}
                    {/*            </div>*/}
                    {/*        </div>*/}
                    {/*    ))}*/}
                    {/*</div>*/}

                    {/*<div className="border-b-1 w-full my-2"></div>*/}

                    {/*<div className="relative flex justify-center items-center border-1 rounded-lg w-full mt-2 p-2 bg-teal-200 z-2">*/}
                    {/*    Show History*/}
                    {/*</div>*/}

                    {/*<div className="border-1 rounded-lg -mt-2 p-2 pt-3">*/}
                    {/*    <span>history will go here</span>*/}
                    {/*</div>*/}
                </div>
            ))}
        </div>
    )
}

export default Home
